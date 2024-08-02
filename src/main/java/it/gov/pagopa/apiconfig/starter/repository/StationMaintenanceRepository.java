package it.gov.pagopa.apiconfig.starter.repository;

import it.gov.pagopa.apiconfig.starter.entity.StationMaintenance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;

@SuppressWarnings("java:S100")
// Disabled naming convention rule for method name to use Spring Data interface
@Repository
public interface StationMaintenanceRepository extends JpaRepository<StationMaintenance, Long> {

    @Query(value =
            "SELECT m " +
                    "FROM StationMaintenance m JOIN FETCH m.station s JOIN FETCH s.intermediarioPa ipa " +
                    "WHERE m.fkStation = s.objId " +
                    "AND s.fkIntermediarioPa = ipa.objId " +
                    "AND ipa.idIntermediarioPa = :brokerCode " +
                    "AND (:stationCode IS NULL OR UPPER(s.idStazione) LIKE CONCAT('%', UPPER(:stationCode), '%')) " +
                    "AND (cast(cast(:startDateTimeBefore as text) as timestamp) IS NULL OR m.startDateTime < cast(cast(:startDateTimeBefore as text) as timestamp)) " +
                    "AND (cast(cast(:startDateTimeAfter as text) as timestamp) IS NULL OR m.startDateTime > cast(cast(:startDateTimeAfter as text) as timestamp)) " +
                    "AND (cast(cast(:endDateTimeBefore as text) as timestamp) IS NULL OR m.endDateTime < cast(cast(:endDateTimeBefore as text) as timestamp)) " +
                    "AND (cast(cast(:endDateTimeAfter as text) as timestamp) IS NULL OR m.endDateTime > cast(cast(:endDateTimeAfter as text) as timestamp))",
    countQuery =
            "SELECT COUNT(m) " +
                    "FROM StationMaintenance m JOIN Stazioni s ON m.fkStation = s.objId JOIN IntermediariPa ipa ON s.fkIntermediarioPa = ipa.objId " +
                    "WHERE ipa.idIntermediarioPa = :brokerCode " +
                    "AND (:stationCode IS NULL OR UPPER(s.idStazione) LIKE CONCAT('%', UPPER(:stationCode), '%')) " +
                    "AND (cast(cast(:startDateTimeBefore as text) as timestamp) IS NULL OR m.startDateTime < cast(cast(:startDateTimeBefore as text) as timestamp)) " +
                    "AND (cast(cast(:startDateTimeAfter as text) as timestamp) IS NULL OR m.startDateTime > cast(cast(:startDateTimeAfter as text) as timestamp)) " +
                    "AND (cast(cast(:endDateTimeBefore as text) as timestamp) IS NULL OR m.endDateTime < cast(cast(:endDateTimeBefore as text) as timestamp)) " +
                    "AND (cast(cast(:endDateTimeAfter as text) as timestamp) IS NULL OR m.endDateTime > cast(cast(:endDateTimeAfter as text) as timestamp))")
    Page<StationMaintenance> findAllByFilters(
            @Param("brokerCode") String brokerCode,
            @Param("stationCode") String stationCode,
            @Param("startDateTimeBefore") OffsetDateTime startDateTimeBefore,
            @Param("startDateTimeAfter") OffsetDateTime startDateTimeAfter,
            @Param("endDateTimeBefore") OffsetDateTime endDateTimeBefore,
            @Param("endDateTimeAfter") OffsetDateTime endDateTimeAfter,
            Pageable pageable
    );
}
