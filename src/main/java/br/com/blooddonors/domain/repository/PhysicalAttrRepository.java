package br.com.blooddonors.domain.repository;

import br.com.blooddonors.domain.entities.PhysicalAttr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhysicalAttrRepository extends JpaRepository<PhysicalAttr, Long> {
}
