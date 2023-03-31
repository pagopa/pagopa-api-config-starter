package it.gov.pagopa.apiconfig.starter.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.gov.pagopa.apiconfig.starter.entity.Canali;

@SuppressWarnings(
    "java:S100") // Disabled naming convention rule for method name to use Spring Data interface
@Repository
public interface CanaliRepository extends JpaRepository<Canali, Long> {

  Optional<Canali> findByIdCanale(String idCanale);

}
