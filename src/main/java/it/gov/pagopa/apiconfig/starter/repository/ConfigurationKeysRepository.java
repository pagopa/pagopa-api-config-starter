package it.gov.pagopa.apiconfig.starter.repository;

import it.gov.pagopa.apiconfig.starter.entity.ConfigurationKeys;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface ConfigurationKeysRepository extends
    JpaRepository<ConfigurationKeys, ConfigurationKeys> {

  Optional<ConfigurationKeys> findByConfigCategoryAndConfigKey(String category, String key);
}
