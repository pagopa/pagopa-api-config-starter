package it.pagopa.pagopa.apiconfigstarter.repository;

import it.pagopa.pagopa.apiconfigstarter.entity.CdiInformazioniServizio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CdiInformazioniServizioRepository extends JpaRepository<CdiInformazioniServizio, Long> {
}
