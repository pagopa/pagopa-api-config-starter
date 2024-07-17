package it.gov.pagopa.apiconfig.starter.repository;

import it.gov.pagopa.apiconfig.starter.entity.StationMaintenanceSummaryId;
import it.gov.pagopa.apiconfig.starter.entity.StationMaintenanceSummaryView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@SuppressWarnings("java:S100")
// Disabled naming convention rule for method name to use Spring Data interface
@Repository
public interface StationMaintenanceSummaryViewRepository extends JpaRepository<StationMaintenanceSummaryView, StationMaintenanceSummaryId> {
}