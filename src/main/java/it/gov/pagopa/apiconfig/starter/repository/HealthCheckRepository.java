package it.gov.pagopa.apiconfig.starter.repository;

import java.util.Optional;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class HealthCheckRepository {

  @Autowired EntityManager entityManager;

  @Value("${healthcheck.query:select 1 from DUAL}")
  private String query;

  public Optional<Object> health() {
    return Optional.of(entityManager.createNativeQuery(query).getSingleResult());
  }
}
