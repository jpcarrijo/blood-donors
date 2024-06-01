package br.com.blooddonors.domain.repository;

import br.com.blooddonors.domain.entities.Donor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonorRepository extends JpaRepository<Donor, Long> {


    Donor findDonorByCpf(String cpf);
}
