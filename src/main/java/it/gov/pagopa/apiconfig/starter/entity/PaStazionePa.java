package it.gov.pagopa.apiconfig.starter.entity;

import it.gov.pagopa.apiconfig.starter.util.YesNoConverter;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(
    name = "PA_STAZIONE_PA",
    uniqueConstraints = {@UniqueConstraint(columnNames = {"FK_PA", "FK_STAZIONE"})})
@Entity
@Getter
@Setter
@ToString
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PaStazionePa {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
  @SequenceGenerator(
      name = "hibernate_sequence",
      sequenceName = "hibernate_sequence",
      allocationSize = 1)
  @Column(name = "OBJ_ID", nullable = false)
  private Long objId;

  @Column(name = "PROGRESSIVO")
  private Long progressivo;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "FK_PA", nullable = false)
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  private Pa pa;

  @Column(name = "FK_PA", nullable = false, insertable = false, updatable = false)
  private Long fkPa;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "FK_STAZIONE", nullable = false)
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  private Stazioni fkStazione;

  @Column(name = "AUX_DIGIT")
  private Long auxDigit;

  @Column(name = "SEGREGAZIONE")
  private Long segregazione;

  @Convert(converter = YesNoConverter.class)
  @Column(name = "QUARTO_MODELLO", nullable = false)
  private Boolean quartoModello = false;

  @Convert(converter = YesNoConverter.class)
  @Column(name = "BROADCAST", nullable = false)
  private Boolean broadcast = false;

  @Convert(converter = YesNoConverter.class)
  @Column(name = "PAGAMENTO_SPONTANEO", nullable = false)
  private Boolean pagamentoSpontaneo = false;

  @Convert(disableConversion = true)
  @Default
  @Column(name = "ACA", nullable = false)
  private Boolean aca = true;

  @Convert(disableConversion = true)
  @Default
  @Column(name = "STANDIN", nullable = false)
  private Boolean standin = true;

}
