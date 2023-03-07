package it.gov.pagopa.apiconfig.starter.repository;

import it.gov.pagopa.apiconfig.starter.entity.CanaliNodo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CanaliNodoRepository extends JpaRepository<CanaliNodo, Long> {}
