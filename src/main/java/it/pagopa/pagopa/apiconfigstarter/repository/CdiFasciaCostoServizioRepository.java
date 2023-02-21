package it.pagopa.pagopa.apiconfigstarter.repository;

import it.pagopa.pagopa.apiconfigstarter.entity.CdiFasciaCostoServizio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CdiFasciaCostoServizioRepository extends JpaRepository<CdiFasciaCostoServizio, Long> {
}
