package it.gov.pagopa.apiconfig.starter.repository;

import it.gov.pagopa.apiconfig.starter.entity.IcaBinaryFile;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IcaBinaryFileRepository extends JpaRepository<IcaBinaryFile, Long> {

  Long deleteByIdDominio(String idDominio);
}
