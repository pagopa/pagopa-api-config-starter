package it.gov.pagopa.apiconfig.starter.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import java.io.Serializable;

@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode
public class StationMaintenanceSummaryId implements Serializable {

    private static final long serialVersionUID = 7800783561114522190L;

    @Column(name = "INTERMEDIARIO_PA_CODICE_FISCALE", nullable = false)
    private String brokerCode;

    @Column(name = "ANNO_MANUTENZIONE", nullable = false)
    private String maintenanceYear;
}
