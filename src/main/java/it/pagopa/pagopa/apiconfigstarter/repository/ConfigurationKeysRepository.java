package it.pagopa.pagopa.apiconfigstarter.repository;

import it.pagopa.pagopa.apiconfigstarter.entity.ConfigurationKeys;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ConfigurationKeysRepository extends JpaRepository<ConfigurationKeys, ConfigurationKeys> {
    Optional<ConfigurationKeys> findByConfigCategoryAndConfigKey(String category, String key);
}
