package it.pagopa.pagopa.apiconfigstarter.repository;

import it.pagopa.pagopa.apiconfigstarter.entity.Codifiche;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodificheRepository extends JpaRepository<Codifiche, Long> {

    Optional<Codifiche> findByIdCodifica(String codeType);
}
