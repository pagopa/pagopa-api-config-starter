package it.gov.pagopa.apiconfig.starter.entity;

import it.gov.pagopa.apiconfig.starter.util.YesNoConverter;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
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
  @EqualsAndHashCode.Exclude
  private List<PspCanaleTipoVersamentoCanale> pspCanaleTipoVersamentoList;
}
