package it.gov.pagopa.apiconfig.starter.repository;

import it.gov.pagopa.apiconfig.starter.entity.GdeConfig;
import it.gov.pagopa.apiconfig.starter.entity.GdeConfigPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GdeConfigRepository extends JpaRepository<GdeConfig, GdeConfigPk> {
}
