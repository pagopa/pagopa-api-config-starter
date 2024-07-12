package it.gov.pagopa.apiconfig.starter.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode
public class StationMaintenanceSummaryId implements Serializable {

    private static final long serialVersionUID = 7800783561114522190L;

    @Column(name = "CI_TAX_CODE", nullable = false)
    private String ciTaxCode;

    @Column(name = "MAINTENANCE_YEAR", nullable = false)
    private String maintenanceYear;
}
