package it.gov.pagopa.apiconfig.starter.repository;

import it.gov.pagopa.apiconfig.starter.entity.CdiMasterValid;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@SuppressWarnings(
    "java:S100") // Disabled naming convention rule for method name to use Spring Data interface
@Repository
public interface CdiMasterValidRepository extends PagingAndSortingRepository<CdiMasterValid, Long> {

  @Query(value = "SELECT distinct(e) FROM CdiMasterValid e LEFT JOIN FETCH e.fkPsp")
  List<CdiMasterValid> findAllFetching();

  Page<CdiMasterValid> findAll(Pageable pageable);

  Optional<CdiMasterValid> findByIdInformativaPspAndFkPsp_IdPsp(String idCdi, String pspCode);

  List<CdiMasterValid> findByFkPsp_IdPspAndDataInizioValiditaLessThanOrderByDataInizioValiditaDesc(
      String idDominio, Timestamp now);
}
