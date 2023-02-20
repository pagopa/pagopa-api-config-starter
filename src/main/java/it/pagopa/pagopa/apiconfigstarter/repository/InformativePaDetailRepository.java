package it.pagopa.pagopa.apiconfigstarter.repository;

import it.pagopa.pagopa.apiconfigstarter.entity.InformativePaDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformativePaDetailRepository extends JpaRepository<InformativePaDetail, Long> {
}
