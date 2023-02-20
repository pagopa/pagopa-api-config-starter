package it.pagopa.pagopa.apiconfigstarter.repository;

import it.pagopa.pagopa.apiconfigstarter.entity.FtpServers;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FtpServersRepository extends JpaRepository<FtpServers, Long> {
    Optional<FtpServers> findByHostAndPortAndService(String host, Integer port, String service);
}
