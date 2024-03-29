package it.gov.pagopa.apiconfig.starter.repository;

import it.gov.pagopa.apiconfig.starter.entity.CodifichePa;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@SuppressWarnings(
    "java:S100") // Disabled naming convention rule for method name to use Spring Data interface
@Repository
public interface CodifichePaRepository extends JpaRepository<CodifichePa, Long> {

  @Query("select cpa from CodifichePa cpa left join fetch cpa.fkCodifica left join fetch cpa.fkPa")
  List<CodifichePa> findAllFetchingCodifiche();

  List<CodifichePa> findAllByFkPa_ObjId(Long fkPa);

  List<CodifichePa> findAllByCodicePaAndFkCodifica_IdCodifica(String codicePa, String idCodifica);

  Optional<CodifichePa> findByCodicePa(String codicePa);

  Optional<CodifichePa> findByCodicePaAndFkPa_ObjId(String codicePa, Long fkPa);
}
