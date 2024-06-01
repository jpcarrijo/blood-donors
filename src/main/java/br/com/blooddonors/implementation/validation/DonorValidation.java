package br.com.blooddonors.implementation.validation;

import br.com.blooddonors.application.dto.DonorDTO;
import br.com.blooddonors.domain.entities.Donor;
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

    public Donor validDonor(DonorDTO dto) {
	return donorRepository.findDonorByCpf(dto.cpf()) != null ? donorRepository.findDonorByCpf(dto.cpf()) : null;
    }

    public static LocalDate returnStringDate(String result) {
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	return LocalDate.parse(result, formatter);
    }
}
