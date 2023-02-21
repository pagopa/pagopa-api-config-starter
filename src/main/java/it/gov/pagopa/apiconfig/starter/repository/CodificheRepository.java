package it.gov.pagopa.apiconfig.starter.repository;

import it.gov.pagopa.apiconfig.starter.entity.Codifiche;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodificheRepository extends JpaRepository<Codifiche, Long> {

  Optional<Codifiche> findByIdCodifica(String codeType);
}
