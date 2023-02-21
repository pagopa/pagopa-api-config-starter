package it.gov.pagopa.apiconfig.starter.repository;

import it.gov.pagopa.apiconfig.starter.entity.IntermediariPsp;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntermediariPspRepository extends JpaRepository<IntermediariPsp, Long> {


  Optional<IntermediariPsp> findByIdIntermediarioPsp(String brokerPspCode);
}
