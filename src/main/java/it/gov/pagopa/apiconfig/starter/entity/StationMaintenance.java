package it.gov.pagopa.apiconfig.starter.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.time.OffsetDateTime;

@Entity
@Table(name = "MANUTENZIONE_STAZIONE")
@Setter
@Getter
@ToString
@Builder
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

    @Column(name = "DATA_ORA_INIZIO", nullable = false)
    private OffsetDateTime startDateTime;

    @Column(name = "DATA_ORA_FINE", nullable = false)
    private OffsetDateTime endDateTime;

    @Convert(disableConversion = true)
    @Column(name = "STANDIN", nullable = false)
    private Boolean standIn;

    @ManyToOne(optional = false)
    @JoinColumn(name = "FK_STAZIONE", nullable = false)
    @ToString.Exclude
    private Stazioni station;

    @Column(name = "FK_STAZIONE", nullable = false, insertable = false, updatable = false)
    private Long fkStation;
}
