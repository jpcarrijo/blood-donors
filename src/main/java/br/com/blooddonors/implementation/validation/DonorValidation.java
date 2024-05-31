package br.com.blooddonors.implementation.validation;

import br.com.blooddonors.application.dto.DonorDTO;
import br.com.blooddonors.domain.exception.RegisteredDonorException;
import br.com.blooddonors.domain.exception.RegisteredEmailException;
import br.com.blooddonors.domain.repository.ContactRepository;
import br.com.blooddonors.domain.repository.DonorRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class DonorValidation {


    final ContactRepository contactRepository;
    final DonorRepository donorRepository;

    public DonorValidation(ContactRepository contactRepository, DonorRepository donorRepository) {
	this.contactRepository = contactRepository;
	this.donorRepository = donorRepository;
    }

    public void validContact(DonorDTO dto) {
	if (contactRepository.findContactByEmail(dto.email()) != null)
	    throw new RegisteredEmailException("Email em uso: " + dto.email());
    }

    public void validDonor(DonorDTO dto) {
	if (donorRepository.findDonorByCpf(dto.cpf()) != null)
	    throw new RegisteredDonorException("Doador registrado: " + dto.name());
    }

    public static LocalDate returnStringDate(String result) {
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	return LocalDate.parse(result, formatter);
    }
}
