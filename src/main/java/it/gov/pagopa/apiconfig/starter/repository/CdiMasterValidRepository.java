package it.gov.pagopa.apiconfig.starter.repository;

import it.gov.pagopa.apiconfig.starter.entity.CdiMasterValid;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@SuppressWarnings("java:S100")
// Disabled naming convention rule for method name to use Spring Data interface
@Repository
public interface CdiMasterValidRepository extends JpaRepository<CdiMasterValid, Long> {

  Optional<CdiMasterValid> findByIdInformativaPspAndPsp_IdPsp(String idCdi, String pspCode);

  List<CdiMasterValid> findByPsp_IdPspAndDataInizioValiditaLessThanOrderByDataInizioValiditaDesc(
      String idDominio, ZonedDateTime now);

  @Query(value = "SELECT distinct(e) FROM CdiMasterValid e LEFT JOIN FETCH e.psp")
  List<CdiMasterValid> findAllFetching();
}
