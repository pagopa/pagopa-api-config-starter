package it.gov.pagopa.apiconfig.starter.entity;

import it.gov.pagopa.apiconfig.starter.util.YesNoConverter;
import java.io.Serializable;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "PSP")
@Entity
@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class Psp implements Serializable {

  private static final long serialVersionUID = 8269368075372242324L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
  @SequenceGenerator(
      name = "hibernate_sequence",
      sequenceName = "hibernate_sequence",
      allocationSize = 1)
  @Column(name = "OBJ_ID", nullable = false)
  private Long objId;

  @Column(name = "ID_PSP", nullable = false, length = 35)
  private String idPsp;

  @Convert(converter = YesNoConverter.class)
  @Column(name = "ENABLED", nullable = false)
  private Boolean enabled;

  @Column(name = "ABI", length = 5)
  private String abi;

  @Column(name = "BIC", length = 11)
  private String bic;

  @Column(name = "DESCRIZIONE", length = 70)
  private String descrizione;

  @Column(name = "RAGIONE_SOCIALE", length = 70)
  private String ragioneSociale;

  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "FK_INT_QUADRATURE")
  private IntermediariPsp fkIntQuadrature;

  @Column(name = "CODICE_MYBANK", length = 35)
  private String codiceMybank;

  @Column(name = "MARCA_BOLLO_DIGITALE", nullable = false)
  private Boolean marcaBolloDigitale;

  @Convert(converter = YesNoConverter.class)
  @Column(name = "AGID_PSP", nullable = false)
  private Boolean agidPsp;

  @Column(name = "CODICE_FISCALE", length = 16)
  private String codiceFiscale;

  @Column(name = "VAT_NUMBER", length = 20)
  private String vatNumber;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "psp")
  @ToString.Exclude
  private List<PspCanaleTipoVersamento> pspCanaleTipoVersamentoList;
}
