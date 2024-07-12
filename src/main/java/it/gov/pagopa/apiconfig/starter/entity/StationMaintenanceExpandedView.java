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
import javax.persistence.Table;
import java.time.OffsetDateTime;

@Entity
@Table(name = "STATION_MAINTENANCE_EXPANDED")
@Setter
@Getter
@ToString
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class StationMaintenanceExpandedView {

    @Id
    @Column(name = "ID", nullable = false)
    private String id;

    @Column(name = "START_DATE_TIME", nullable = false)
    private OffsetDateTime startDateTime;

    @Column(name = "END_DATE_TIME", nullable = false)
    private OffsetDateTime endDateTime;

    @Column(name = "CI_TAX_CODE", nullable = false)
    private String ciTaxCode;
}