package it.gov.pagopa.apiconfig.starter.repository;

import it.gov.pagopa.apiconfig.starter.entity.StationMaintenance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@SuppressWarnings("java:S100")
// Disabled naming convention rule for method name to use Spring Data interface
@Repository
public interface StationMaintenanceRepository extends JpaRepository<StationMaintenance, Long> {

    @Query(value =
            "SELECT * " +
                    "FROM StationMaintenance m JOIN Stazioni s ON m.fkStation = s.objId " +
                    "WHERE (:stationCode IS NULL OR UPPER(s.idStazione) LIKE CONCAT('%', UPPER(:stationCode), '%')) " +
                    "AND (:ciTaxCode IS NULL OR m.ciTaxCode = :ciTaxCode) " +
                    "AND (:startDateTimeBefore IS NULL OR m.startDateTime < :startDateTimeBefore) " +
                    "AND (:startDateTimeAfter IS NULL OR m.startDateTime > :startDateTimeAfter) " +
                    "AND (:endDateTimeBefore IS NULL OR m.endDateTime < :endDateTimeBefore) " +
                    "AND (:endDateTimeAfter IS NULL OR m.endDateTime > :endDateTimeAfter)")
    Page<StationMaintenance> findAllByFilters(
            @Param("stationCode") String stationCode,
            @Param("ciTaxCode") String ciTaxCode,
            @Param("startDateTimeBefore") String startDateTimeBefore,
            @Param("startDateTimeAfter") String startDateTimeAfter,
            @Param("endDateTimeBefore") String endDateTimeBefore,
            @Param("endDateTimeAfter") String endDateTimeAfter,
            Pageable pageable
    );
}
