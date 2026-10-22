package it.gov.pagopa.apiconfig.starter.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@Entity
@Table(name = "CDI_FASCIA_COSTO_SERVIZIO")
public class CdiFasciaCostoServizio {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
  @SequenceGenerator(
      name = "hibernate_sequence",
      sequenceName = "hibernate_sequence",
      allocationSize = 1)
  @Column(name = "OBJ_ID", nullable = false)
  private Long id;

  @Column(name = "IMPORTO_MINIMO", nullable = false)
  private Double importoMinimo;

  @Column(name = "IMPORTO_MASSIMO", nullable = false)
  private Double importoMassimo;

  @Column(name = "COSTO_FISSO", nullable = false)
  private Double costoFisso;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "FK_CDI_DETAIL", nullable = false)
  @ToString.Exclude
  private CdiDetail fkCdiDetail;

  @Column(name = "VALORE_COMMISSIONE")
  private Double valoreCommissione;

  @Column(name = "CODICE_CONVENZIONE", length = 35)
  private String codiceConvenzione;
}
