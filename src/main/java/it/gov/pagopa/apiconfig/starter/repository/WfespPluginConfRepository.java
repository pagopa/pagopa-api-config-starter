package it.gov.pagopa.apiconfig.starter.repository;

import it.gov.pagopa.apiconfig.starter.entity.WfespPluginConf;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WfespPluginConfRepository extends JpaRepository<WfespPluginConf, Long> {

  Optional<WfespPluginConf> findByIdServPlugin(String id);
}
