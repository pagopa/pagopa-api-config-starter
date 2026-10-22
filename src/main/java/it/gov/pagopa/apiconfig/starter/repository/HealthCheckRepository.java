package it.gov.pagopa.apiconfig.starter.repository;

import jakarta.persistence.EntityManager;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class HealthCheckRepository {

  private final EntityManager entityManager;
  private final String query;

  public HealthCheckRepository(
      EntityManager entityManager, @Value("${healthcheck.query:select 1 from DUAL}") String query) {
    this.entityManager = entityManager;
    this.query = query;
  }

  public Optional<Object> health() {
    return Optional.of(entityManager.createNativeQuery(query).getSingleResult());
  }
}
