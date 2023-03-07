package it.gov.pagopa.apiconfig.starter.entity;

import it.gov.pagopa.apiconfig.starter.util.YesNoConverter;
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

@Table(name = "PA")
@Entity
@Getter
@Setter
@ToString
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Pa {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
  @SequenceGenerator(
      name = "hibernate_sequence",
      sequenceName = "hibernate_sequence",
      allocationSize = 1)
  @Column(name = "OBJ_ID", nullable = false)
  private Long objId;

  @Column(name = "ID_DOMINIO", unique = true)
  private String idDominio;

  @Column(name = "DESCRIZIONE")
  private String description;

  @Convert(converter = YesNoConverter.class)
  @Column(name = "ENABLED")
  private Boolean enabled;

  @Column(name = "RAGIONE_SOCIALE")
  private String ragioneSociale;

  @Column(name = "INDIRIZZO_DOMICILIO_FISCALE")
  private String indirizzoDomicilioFiscale;

  @Column(name = "CAP_DOMICILIO_FISCALE")
  private String capDomicilioFiscale;

  @Column(name = "SIGLA_PROVINCIA_DOMICILIO_FISCALE")
  private String siglaProvinciaDomicilioFiscale;

  @Column(name = "COMUNE_DOMICILIO_FISCALE")
  private String comuneDomicilioFiscale;

  @Column(name = "DENOMINAZIONE_DOMICILIO_FISCALE")
  private String denominazioneDomicilioFiscale;

  @Convert(converter = YesNoConverter.class)
  @Column(name = "PAGAMENTO_PRESSO_PSP")
  private Boolean pagamentoPressoPsp;

  @Convert(converter = YesNoConverter.class)
  @Column(name = "RENDICONTAZIONE_FTP")
  private Boolean rendicontazioneFtp;

  @Convert(converter = YesNoConverter.class)
  @Column(name = "RENDICONTAZIONE_ZIP")
  private Boolean rendicontazioneZip;

  @ToString.Exclude
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "pa")
  @EqualsAndHashCode.Exclude
  private List<IbanValidiPerPa> ibans;

  @ToString.Exclude
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "pa")
  @EqualsAndHashCode.Exclude
  private List<InformativePaMaster> informativePaMasters;
}
