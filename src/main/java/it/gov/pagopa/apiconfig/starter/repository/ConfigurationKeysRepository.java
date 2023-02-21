package it.gov.pagopa.apiconfig.starter.repository;

import it.gov.pagopa.apiconfig.starter.entity.ConfigurationKeys;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ConfigurationKeysRepository extends
    JpaRepository<ConfigurationKeys, ConfigurationKeys> {

  Optional<ConfigurationKeys> findByConfigCategoryAndConfigKey(String category, String key);
}
