package br.com.blooddonors.implementation.service;

import br.com.blooddonors.application.dto.DonorDTO;
import br.com.blooddonors.domain.entities.*;
import br.com.blooddonors.domain.protocols.DonorServicePort;
import br.com.blooddonors.domain.repository.*;
import br.com.blooddonors.implementation.validation.DonorValidation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DonorImpl implements DonorServicePort {


    final DonorRepository donorRepository;
    final AddressRepository addressRepository;
    final ContactRepository contactRepository;
    final ParentRepository parentRepository;
    final PhysicalAttrRepository physicalAttrRepository;
    final DonorValidation donorValidation;

    public DonorImpl(DonorRepository donorRepository, AddressRepository addressRepository,
		     ContactRepository contactRepository,
		     ParentRepository parentRepository, PhysicalAttrRepository physicalAttrRepository,
		     DonorValidation donorValidation) {
	this.donorRepository = donorRepository;
	this.addressRepository = addressRepository;
	this.contactRepository = contactRepository;
	this.parentRepository = parentRepository;
	this.physicalAttrRepository = physicalAttrRepository;
	this.donorValidation = donorValidation;
    }


    @Override
    @Transactional
    public void saveDonor(List<DonorDTO> dtoList) {
	dtoList.forEach(e -> {
	    donorValidation.validDonor(e);
	    donorValidation.validContact(e);

	    Address address = Address.builder(e);
	    address = addressRepository.save(address);

	    Contact contact = Contact.builder(e);
	    contact = contactRepository.save(contact);

	    Parent parent = Parent.builder(e);
	    parent = parentRepository.save(parent);

	    PhysicalAttr physicalAttr = PhysicalAttr.builder(e);
	    physicalAttr = physicalAttrRepository.save(physicalAttr);

	    Donor donor = Donor.builder(e, physicalAttr, parent, address, contact);
	    donorRepository.save(donor);
	});
    }

}
