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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.ZonedDateTime;

@Entity
@Table(name = "STATION_MAINTENANCE")
@Setter
@Getter
@ToString
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class StationMaintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
    @SequenceGenerator(
            name = "hibernate_sequence",
            sequenceName = "hibernate_sequence",
            allocationSize = 1)
    @Column(name = "OBJ_ID", nullable = false)
    private Long objId;

    @Column(name = "START_DATE_TIME", nullable = false)
    private ZonedDateTime startDateTime;

    @Column(name = "END_DATE_TIME", nullable = false)
    private ZonedDateTime endDateTime;

    @Column(name = "STANDIN", nullable = false)
    private Boolean standIn;

    @ManyToOne(optional = false)
    @JoinColumn(name = "FK_STATION", nullable = false)
    @ToString.Exclude
    private Stazioni station;

    @Column(name = "FK_STATION", nullable = false, insertable = false, updatable = false)
    private Long fkStation;

    @Column(name = "CI_TAX_CODE", nullable = false)
    private String ciTaxCode;
}
