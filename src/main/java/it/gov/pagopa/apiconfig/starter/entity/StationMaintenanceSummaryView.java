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
@Table(name = "MANUTENZIONE_STAZIONE_RIEPILOGO")
@IdClass(StationMaintenanceSummaryId.class)
@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class StationMaintenanceSummaryView {

    @Id
    @Column(name = "INTERMEDIARIO_PA_CODICE_FISCALE", nullable = false)
    private String brokerCode;

    @Id
    @Column(name = "ANNO_MANUTENZIONE", nullable = false)
    private String maintenanceYear;

    @Column(name = "ORE_UTILIZZATE", nullable = false)
    private Double usedHours;

    @Column(name = "ORE_PROGRAMMATE", nullable = false)
    private Double scheduledHours;
}
