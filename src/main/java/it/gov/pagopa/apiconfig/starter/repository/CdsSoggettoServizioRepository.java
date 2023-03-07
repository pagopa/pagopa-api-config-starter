package it.gov.pagopa.apiconfig.starter.repository;

import it.gov.pagopa.apiconfig.starter.entity.CdsSoggettoServizio;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CdsSoggettoServizioRepository extends JpaRepository<CdsSoggettoServizio, Long> {

  @Query(
      value =
          "SELECT e FROM CdsSoggettoServizio e LEFT JOIN FETCH e.soggetto LEFT JOIN FETCH e.servizio")
  List<CdsSoggettoServizio> findAllFetching();
}
