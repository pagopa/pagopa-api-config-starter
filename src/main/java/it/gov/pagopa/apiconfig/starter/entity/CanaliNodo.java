package it.gov.pagopa.apiconfig.starter.entity;

import it.gov.pagopa.apiconfig.starter.util.YesNoConverter;
import java.io.Serializable;
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
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@Entity
@Table(name = "CANALI_NODO")
@Builder
public class CanaliNodo implements Serializable {

  private static final long serialVersionUID = 5955835074918169426L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
  @SequenceGenerator(
      name = "hibernate_sequence",
      sequenceName = "hibernate_sequence",
      allocationSize = 1)
  @Column(name = "OBJ_ID", nullable = false)
  private Long id;

  @Column(name = "REDIRECT_IP", length = 100)
  private String redirectIp;

  @Column(name = "REDIRECT_PATH", length = 100)
  private String redirectPath;

  @Column(name = "REDIRECT_PORTA")
  private Long redirectPorta;

  @Column(name = "REDIRECT_QUERY_STRING")
  private String redirectQueryString;

  @Column(name = "MODELLO_PAGAMENTO", nullable = false)
  private String modelloPagamento;

  @Convert(converter = YesNoConverter.class)
  @Column(name = "MULTI_PAYMENT", nullable = false)
  private Boolean multiPayment = false;

  @Column(name = "RAGIONE_SOCIALE", length = 35)
  private String ragioneSociale;

  @Convert(converter = YesNoConverter.class)
  @Column(name = "RPT_RT_COMPLIANT", nullable = false)
  private Boolean rptRtCompliant = false;

  @Column(name = "WSAPI", length = 15)
  private String wsapi;

  @Column(name = "REDIRECT_PROTOCOLLO", length = 35)
  private String redirectProtocollo;

  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ID_SERV_PLUGIN", referencedColumnName = "ID_SERV_PLUGIN")
  private WfespPluginConf idServPlugin;

  @Column(name = "ID_CLUSTER")
  private String idCluster;

  @Column(name = "ID_FESP_INSTANCE", length = 275)
  private String idFespInstance;

  @Convert(converter = YesNoConverter.class)
  @Column(name = "LENTO", nullable = false)
  private Boolean lento = false;

  @Convert(converter = YesNoConverter.class)
  @Column(name = "RT_PUSH", nullable = false)
  private Boolean rtPush = false;

  @Convert(converter = YesNoConverter.class)
  @Column(name = "AGID_CHANNEL", nullable = false)
  private Boolean agidChannel = false;

  @Convert(converter = YesNoConverter.class)
  @Column(name = "ON_US", nullable = false)
  private Boolean onUs = false;

  @Convert(converter = YesNoConverter.class)
  @Column(name = "CARRELLO_CARTE", nullable = false)
  private Boolean carrelloCarte = false;

  @Convert(converter = YesNoConverter.class)
  @Column(name = "RECOVERY", nullable = false)
  private Boolean recovery = false;

  @Convert(converter = YesNoConverter.class)
  @Column(name = "MARCA_BOLLO_DIGITALE", nullable = false)
  private Boolean marcaBolloDigitale = false;

  @Convert(converter = YesNoConverter.class)
  @Column(name = "FLAG_IO")
  private Boolean flagIo;

  @Column(name = "VERSIONE_PRIMITIVE")
  private Integer versionePrimitive;

  @Convert(converter = YesNoConverter.class)
  @Column(name = "FLAG_TRAVASO", nullable = false)
  private Boolean flagTravaso = false;

  @Convert(converter = YesNoConverter.class)
  @Column(name = "FLAG_STANDIN", nullable = false)
  private Boolean flagStandin = false;
}
