package it.gov.pagopa.apiconfig.starter.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.OffsetDateTime;

@Entity
@Table(name = "MANUTENZIONE_STAZIONE_ESPANSA")
@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class StationMaintenanceExpandedView {

    @Id
    @Column(name = "ID", nullable = false)
    private String id;

    @Column(name = "DATA_ORA_INIZIO", nullable = false)
    private OffsetDateTime startDateTime;

    @Column(name = "DATA_ORA_FINE", nullable = false)
    private OffsetDateTime endDateTime;

    @Column(name = "INTERMEDIARIO_PA_CODICE_FISCALE", nullable = false)
    private String brokerCode;
}