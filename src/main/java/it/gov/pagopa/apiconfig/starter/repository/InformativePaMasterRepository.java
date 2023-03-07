package it.gov.pagopa.apiconfig.starter.repository;

import it.gov.pagopa.apiconfig.starter.entity.InformativePaMaster;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@SuppressWarnings("java:S100")
// Disabled naming convention rule for method name to use Spring Data interface
@Repository
public interface InformativePaMasterRepository extends JpaRepository<InformativePaMaster, Long> {

  Optional<InformativePaMaster> findByIdInformativaPaAndPa_IdDominio(
      String idCounterpartTable, String creditorInstitutionCode);

  List<InformativePaMaster>
      findByPa_IdDominioAndDataInizioValiditaLessThanOrderByDataInizioValiditaDesc(
          String idDominio, ZonedDateTime now);
}
