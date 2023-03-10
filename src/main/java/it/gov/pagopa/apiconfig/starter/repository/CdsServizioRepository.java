package it.gov.pagopa.apiconfig.starter.repository;

import it.gov.pagopa.apiconfig.starter.entity.CdsServizio;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CdsServizioRepository extends JpaRepository<CdsServizio, Long> {

  @Query(value = "SELECT e FROM CdsServizio e LEFT JOIN FETCH e.categoria")
  List<CdsServizio> findAllFetching();
}
