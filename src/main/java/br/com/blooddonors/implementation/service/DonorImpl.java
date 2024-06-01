package br.com.blooddonors.implementation.service;

import br.com.blooddonors.application.dto.*;
import br.com.blooddonors.domain.entities.*;
import br.com.blooddonors.domain.exception.InternalServeException;
import br.com.blooddonors.domain.protocols.DonorServicePort;
import br.com.blooddonors.domain.repository.*;
import br.com.blooddonors.implementation.validation.DonorValidation;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class DonorImpl implements DonorServicePort {


    final DonorRepository donorRepository;
    final AddressRepository addressRepository;
    final ContactRepository contactRepository;
    final ParentRepository parentRepository;
    final PhysicalAttrRepository physicalAttrRepository;
    final DonorValidation donorValidation;
    final ObjectMapper mapper;

    public DonorImpl(DonorRepository donorRepository, AddressRepository addressRepository,
		     ContactRepository contactRepository,
		     ParentRepository parentRepository, PhysicalAttrRepository physicalAttrRepository,
		     DonorValidation donorValidation, ObjectMapper mapper) {
	this.donorRepository = donorRepository;
	this.addressRepository = addressRepository;
	this.contactRepository = contactRepository;
	this.parentRepository = parentRepository;
	this.physicalAttrRepository = physicalAttrRepository;
	this.donorValidation = donorValidation;
	this.mapper = mapper;
    }


    @Override
    @Transactional
    public DataView saveDonor(MultipartFile file) {
	List<DonorDTO> dtoList = new ArrayList<>();
	try (InputStream inputStream = file.getInputStream()) {
	    if (file.isEmpty()) {
		throw new IllegalArgumentException("O arquivo está vazio.");
	    }
	    dtoList = mapper.readValue(inputStream, new TypeReference<>() { });
	} catch (IOException e) {
	    throw new InternalServeException("Erro ao processar o arquivo.");
	}

	long startTime = System.currentTimeMillis();

	List<Donor> donorList = new ArrayList<>();
	List<Address> addressList = new ArrayList<>();
	List<Contact> contactList = new ArrayList<>();
	List<Parent> parentList = new ArrayList<>();
	List<PhysicalAttr> physicalList = new ArrayList<>();
	dtoList.forEach(e -> {
	    Donor donor = donorValidation.validDonor(e);
	    if (donor == null) {
		Address address = Address.builder(e);
		addressList.add(address);

		Contact contact = Contact.builder(e);
		contactList.add(contact);

		Parent parent = Parent.builder(e);
		parentList.add(parent);

		PhysicalAttr physicalAttr = PhysicalAttr.builder(e);
		physicalList.add(physicalAttr);

		donor = Donor.builder(e, physicalAttr, parent, address, contact);
		donorList.add(donor);
	    }
	});
	saveBatch(addressList, contactList, parentList, physicalList, donorList);

	long endTime = System.currentTimeMillis();
	long duration = endTime - startTime;
	System.out.println("Tempo total de execução: " + duration + "ms");

	return toDataView(dtoList);
    }

    private void saveBatch(List<Address> addressList, List<Contact> contactList,
			   List<Parent> parentList, List<PhysicalAttr> physicalList,
			   List<Donor> donorList) {
	addressRepository.saveAll(addressList);
	contactRepository.saveAll(contactList);
	parentRepository.saveAll(parentList);
	physicalAttrRepository.saveAll(physicalList);
	donorRepository.saveAll(donorList);
    }

    private TotalByState calcByState(List<DonorDTO> dtoList) {
	Map<String, Integer> map = new LinkedHashMap<>();
	dtoList.forEach(e -> {
	    String state = e.state();
	    map.put(state, map.getOrDefault(state, 0) + 1);
	});
	return new TotalByState(map);
    }

    private int calcAge(String birth) {
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	LocalDate dateOfBirth = LocalDate.parse(birth, formatter);
	LocalDate dateNow = LocalDate.now();
	return Period.between(dateOfBirth, dateNow).getYears();
    }

    private String calcAgeRange(int age) {
	int startInterval = age <= 10 ? 0 : ((age - 1) / 10) * 10 + 1;
	int endInterval = age <= 10 ? 10 : startInterval + 9;

	return startInterval + " a " + endInterval + " anos";
    }

    private double calcIMC(DonorDTO donor) {
	return donor.weight() / (donor.height() * donor.height());
    }

    private AverageIMC calcAverageIMC(List<DonorDTO> dtoList) {
	Map<String, List<Double>> imcByInterval = new TreeMap<>(new Comparator<String>() {
	    @Override
	    public int compare(String o1, String o2) {
		int age1 = Integer.parseInt(o1.split(" ")[0]); // Extrai a idade inicial da primeira faixa
		int age2 = Integer.parseInt(o2.split(" ")[0]); // Extrai a idade inicial da segunda faixa
		return Integer.compare(age1, age2); // Compara as idades
	    }
	});

	dtoList.forEach(e -> {
	    imcByInterval.computeIfAbsent(calcAgeRange(calcAge(e.dateOfBirth())), k -> new ArrayList<>()).add(calcIMC(e));
	});

	return new AverageIMC(imcByInterval.entrySet()
					   .stream()
					   .collect(Collectors
							.toMap(
							    Map.Entry::getKey,
							    e -> Math.round(e.getValue()
									     .stream()
									     .mapToDouble(Double::doubleValue)
									     .average()
									     .orElse(0.0) * 100.0) / 100.0,
							    (a, b) -> a, TreeMap::new)));
    }


    private ObesityStats obeseCalcGender(List<DonorDTO> dtoList,
					 String gender) {
	int totalPeople = (int) dtoList.stream()
				       .filter(pessoa -> pessoa.sex().equalsIgnoreCase(gender))
				       .count();

	double obeseGender = dtoList.stream()
				    .filter(pessoa -> pessoa.sex().equalsIgnoreCase(gender))
				    .filter(pessoa -> {
					double imc = calcIMC(pessoa);
					return imc > 30;
				    })
				    .count();

	return new ObesityStats(totalPeople, obeseGender / totalPeople * 100);
    }

    private List<ObesePercentage> obeseCalcPercent(List<DonorDTO> dtoList) {

	ObesityStats maleObesityStats = obeseCalcGender(dtoList, "Masculino");
	ObesityStats femaleObesityStats = obeseCalcGender(dtoList, "Feminino");

	return Arrays.asList(new ObesePercentage("Masculino", maleObesityStats),
			     new ObesePercentage("Feminino", femaleObesityStats));
    }

    private AverageBloodTypeByAge calcAverageAgeByBloodType(List<DonorDTO> dtoList) {
	Map<String, Double> averageByBloodType = dtoList.stream()
							.collect(Collectors.groupingBy(
							    DonorDTO::bloodType,
							    Collectors.collectingAndThen(
								Collectors.averagingInt(e -> calcAge(e.dateOfBirth())),
								av -> BigDecimal.valueOf(av).setScale(
								    2, RoundingMode.HALF_UP).doubleValue())));
	return new AverageBloodTypeByAge(averageByBloodType);
    }

    private boolean isValidDonor(DonorDTO dto) {
	int idade = calcAge(dto.dateOfBirth());
	return idade >= 16 && idade <= 69 && dto.weight() > 50;
    }

    private Map<String, List<String>> getBloodCompatibility() {
	Map<String, List<String>> compatibilityMap = new HashMap<>();
	compatibilityMap.put("A+", List.of("A+", "AB+"));
	compatibilityMap.put("A-", List.of("A+", "A-", "AB+", "AB-"));
	compatibilityMap.put("B+", List.of("B+", "AB+"));
	compatibilityMap.put("B-", List.of("B+", "B-", "AB+", "AB-"));
	compatibilityMap.put("AB+", List.of("AB+"));
	compatibilityMap.put("AB-", List.of("AB+", "AB-"));
	compatibilityMap.put("O+", List.of("O+", "A+", "B+", "AB+"));
	compatibilityMap.put("O-", List.of("O+", "O-", "A+", "A-", "B+", "B-", "AB+", "AB-"));
	return compatibilityMap;
    }

    private DonorsToRecipients calcDonorsPerRecipient(List<DonorDTO> dtoList) {
	Map<String, List<String>> bloodCompatibilityMap = getBloodCompatibility();

	List<DonorDTO> validDonors = dtoList.stream()
					    .filter(this::isValidDonor)
					    .collect(Collectors.toList());

	Map<String, Long> donorsPerRecipient = new LinkedHashMap<>();

	for (String receptor : bloodCompatibilityMap.keySet()) {
	    long count = validDonors.stream()
				    .filter(don -> bloodCompatibilityMap
					.get(don.bloodType())
					.contains(receptor)).count();
	    donorsPerRecipient.put(receptor, count);
	}
	return new DonorsToRecipients(donorsPerRecipient);
    }

    private DataView toDataView(List<DonorDTO> dtoList) {
	TotalByState totalByState = calcByState(dtoList);
	AverageIMC averageIMC = calcAverageIMC(dtoList);
	List<ObesePercentage> obesePercentageList = obeseCalcPercent(dtoList);
	AverageBloodTypeByAge averageByAge = calcAverageAgeByBloodType(dtoList);
	DonorsToRecipients receivers = calcDonorsPerRecipient(dtoList);

	return new DataView(totalByState,
			    averageIMC,
			    obesePercentageList,
			    averageByAge,
			    receivers);
    }

}
