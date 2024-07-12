package it.gov.pagopa.apiconfig.starter.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "STATION_MAINTENANCE_SUMMARY")
@IdClass(StationMaintenanceSummaryId.class)
@Setter
@Getter
@ToString
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class StationMaintenanceSummaryView {

    @Id
    @Column(name = "CI_TAX_CODE", nullable = false)
    private String ciTaxCode;

    @Id
    @Column(name = "MAINTENANCE_YEAR", nullable = false)
    private String maintenanceYear;

    @Column(name = "USED_HOURS", nullable = false)
    private Double usedHours;

    @Column(name = "SCHEDULED_HOURS", nullable = false)
    private Double scheduledHours;
}
