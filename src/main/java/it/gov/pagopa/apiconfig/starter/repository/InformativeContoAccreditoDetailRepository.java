package it.gov.pagopa.apiconfig.starter.repository;

import it.gov.pagopa.apiconfig.starter.entity.InformativeContoAccreditoDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformativeContoAccreditoDetailRepository extends
    JpaRepository<InformativeContoAccreditoDetail, Long> {

}
