package it.gov.pagopa.apiconfig.starter.repository;

import it.gov.pagopa.apiconfig.starter.entity.Pa;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaRepository extends JpaRepository<Pa, Long> {

  Optional<Pa> findByIdDominio(String creditorInstitutionCode);

  Optional<List<Pa>> findByIdDominioIn(List<String> creditorInstitutionCodes);
}
