package it.gov.pagopa.apiconfig.starter.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.gov.pagopa.apiconfig.starter.entity.Pa;

@Repository
public interface PaRepository extends JpaRepository<Pa, Long> {

  Optional<Pa> findByIdDominio(String creditorInstitutionCode);
}
