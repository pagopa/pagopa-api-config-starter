package it.pagopa.pagopa.apiconfigstarter.repository;

import it.pagopa.pagopa.apiconfigstarter.entity.IntermediariPa;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntermediariPaRepository extends JpaRepository<IntermediariPa, Long> {

    Optional<IntermediariPa> findByIdIntermediarioPa(String brokerCode);
}
