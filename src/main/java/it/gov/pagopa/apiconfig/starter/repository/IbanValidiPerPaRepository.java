package it.gov.pagopa.apiconfig.starter.repository;

import it.gov.pagopa.apiconfig.starter.entity.IbanValidiPerPa;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IbanValidiPerPaRepository extends JpaRepository<IbanValidiPerPa, String> {

  @Query(value = "SELECT e FROM IbanValidiPerPa e LEFT JOIN FETCH e.pa")
  List<IbanValidiPerPa> findAllFetchingPas();

  List<IbanValidiPerPa> findAllByFkPa(Long fkPa);

  List<IbanValidiPerPa> findAllByIbanAccreditoContainsIgnoreCase(String iban);
}
