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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "STATION_MAINTENANCE_SUMMARY")
@Setter
@Getter
@ToString
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class StationMaintenanceSummaryView {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
    @SequenceGenerator(
            name = "hibernate_sequence",
            sequenceName = "hibernate_sequence",
            allocationSize = 1)
    @Column(name = "OBJ_ID", nullable = false)
    private Long objId;

    @Column(name = "CI_TAX_CODE", nullable = false)
    private String ciTaxCode;

    @Column(name = "YEAR", nullable = false)
    private String year;

    @Column(name = "USED_HOURS", nullable = false)
    private Double usedHours;

    @Column(name = "SCHEDULED_HOURS", nullable = false)
    private Double scheduledHours;
}
