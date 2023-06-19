package it.gov.pagopa.apiconfig.starter.repository;

import it.gov.pagopa.apiconfig.starter.entity.IcaBinaryFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface IcaBinaryFileRepository extends JpaRepository<IcaBinaryFile, Long> {

  Optional<IcaBinaryFile> findByIdDominio(String idDominio);

}
