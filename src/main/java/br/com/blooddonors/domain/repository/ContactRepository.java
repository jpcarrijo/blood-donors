package br.com.blooddonors.domain.repository;

import br.com.blooddonors.domain.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {


    Contact findContactByEmail(String email);
}
