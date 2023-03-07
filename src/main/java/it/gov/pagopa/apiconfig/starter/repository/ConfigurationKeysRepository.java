package it.gov.pagopa.apiconfig.starter.repository;

import it.gov.pagopa.apiconfig.starter.entity.ConfigurationKeys;
import it.gov.pagopa.apiconfig.starter.entity.ConfigurationKeysView;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigurationKeysRepository
    extends JpaRepository<ConfigurationKeys, ConfigurationKeysView> {

  Optional<ConfigurationKeys> findByConfigCategoryAndConfigKey(
      String configCategory, String configKey);
}
