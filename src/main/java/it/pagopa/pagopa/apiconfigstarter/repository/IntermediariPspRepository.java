package it.pagopa.pagopa.apiconfigstarter.repository;

import it.pagopa.pagopa.apiconfigstarter.entity.IntermediariPsp;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntermediariPspRepository extends JpaRepository<IntermediariPsp, Long> {


    Optional<IntermediariPsp> findByIdIntermediarioPsp(String brokerPspCode);
}
