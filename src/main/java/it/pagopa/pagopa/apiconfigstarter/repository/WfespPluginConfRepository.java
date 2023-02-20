package it.pagopa.pagopa.apiconfigstarter.repository;

import it.pagopa.pagopa.apiconfigstarter.entity.WfespPluginConf;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WfespPluginConfRepository extends JpaRepository<WfespPluginConf, Long> {

    Optional<WfespPluginConf> findByIdServPlugin(String id);
}
