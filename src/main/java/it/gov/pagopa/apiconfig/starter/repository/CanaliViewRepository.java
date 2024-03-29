package it.gov.pagopa.apiconfig.starter.repository;

import it.gov.pagopa.apiconfig.starter.entity.CanaliView;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@SuppressWarnings("java:S100")
// Disabled naming convention rule for method name to use Spring Data interface
@Repository
public interface CanaliViewRepository extends JpaRepository<CanaliView, Long> {

  Optional<CanaliView> findByIdCanale(String idCanale);

  List<CanaliView> findByIntermediarioPsp_idIntermediarioPsp(String brokerCode);

  @Query(value = "SELECT c FROM CanaliView c LEFT JOIN FETCH c.intermediarioPsp")
  List<CanaliView> findAllFetchingIntermediario();
}
