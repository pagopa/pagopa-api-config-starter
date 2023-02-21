package it.gov.pagopa.apiconfig.starter.repository;

import it.gov.pagopa.apiconfig.starter.entity.IntermediariPa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface IntermediariPaRepository extends JpaRepository<IntermediariPa, Long> {

  Optional<IntermediariPa> findByIdIntermediarioPa(String brokerCode);
}
