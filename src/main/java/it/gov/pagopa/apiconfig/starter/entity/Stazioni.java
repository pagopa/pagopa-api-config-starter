package it.gov.pagopa.apiconfig.starter.entity;

import it.gov.pagopa.apiconfig.starter.util.YesNoConverter;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "STAZIONI")
@Setter
@Getter
@ToString
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Stazioni {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
  @SequenceGenerator(
      name = "hibernate_sequence",
      sequenceName = "hibernate_sequence",
      allocationSize = 1)
  @Column(name = "OBJ_ID", nullable = false)
  private Long objId;

  @Column(name = "ID_STAZIONE")
  private String idStazione;

  @Column(name = "ENABLED")
  @Convert(converter = YesNoConverter.class)
  private Boolean enabled;

  @Column(name = "IP")
  private String ip;

  @ToString.Exclude
  @Column(name = "PASSWORD")
  private String password;

  @Column(name = "PORTA")
  private Long porta;

  @Column(name = "PROTOCOLLO", nullable = false)
  private String protocollo;

  @Column(name = "REDIRECT_IP")
  private String redirectIp;

  @Column(name = "REDIRECT_PATH")
  private String redirectPath;

  @Column(name = "REDIRECT_PORTA")
  private Long redirectPorta;

  @Column(name = "REDIRECT_QUERY_STRING")
  private String redirectQueryString;

  @Column(name = "SERVIZIO")
  private String servizio;

  @Column(name = "RT_ENABLED")
  @Convert(converter = YesNoConverter.class)
  private Boolean rtEnabled = true;

  @Column(name = "SERVIZIO_POF")
  private String servizioPof;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "FK_INTERMEDIARIO_PA", nullable = false)
  @ToString.Exclude
  private IntermediariPa intermediarioPa;

  @Column(name = "FK_INTERMEDIARIO_PA", nullable = false, insertable = false, updatable = false)
  private Long fkIntermediarioPa;

  @Column(name = "REDIRECT_PROTOCOLLO")
  private String redirectProtocollo;

  @Column(name = "PROTOCOLLO_4MOD")
  private String protocollo4Mod;

  @Column(name = "IP_4MOD")
  private String ip4Mod;

  @Column(name = "PORTA_4MOD")
  private Long porta4Mod;

  @Column(name = "SERVIZIO_4MOD")
  private String servizio4Mod;

  @Column(name = "PROXY_ENABLED")
  @Convert(converter = YesNoConverter.class)
  private Boolean proxyEnabled;

  @Column(name = "PROXY_HOST")
  private String proxyHost;

  @Column(name = "PROXY_PORT")
  private Long proxyPort;

  @Column(name = "PROXY_USERNAME")
  private String proxyUsername;

  @ToString.Exclude
  @Column(name = "PROXY_PASSWORD")
  private String proxyPassword;

  @Column(name = "NUM_THREAD")
  private Long numThread;

  @Column(name = "TIMEOUT_A")
  private Long timeoutA;

  @Column(name = "TIMEOUT_B")
  private Long timeoutB;

  @Column(name = "TIMEOUT_C")
  private Long timeoutC;

  @Column(name = "FLAG_ONLINE")
  @Convert(converter = YesNoConverter.class)
  private Boolean flagOnline;

  @Column(name = "VERSIONE")
  private Long versione;

  @Column(name = "SERVIZIO_NMP")
  private String servizioNmp;

  @Column(name = "INVIO_RT_ISTANTANEO")
  @Convert(converter = YesNoConverter.class)
  private Boolean invioRtIstantaneo;

  @Column(name = "TARGET_HOST")
  private String targetHost;

  @Column(name = "TARGET_PORT")
  private Long targetPort;

  @Column(name = "TARGET_PATH")
  private String targetPath;

  @Column(name = "TARGET_HOST_POF")
  private String targetHostPof;

  @Column(name = "TARGET_PORT_POF")
  private Long targetPortPof;

  @Column(name = "TARGET_PATH_POF")
  private String targetPathPof;

  @Convert(converter = YesNoConverter.class)
  @Column(name = "FLAG_STANDIN", nullable = false)
  private Boolean flagStandin = false;

  @Column(name = "VERSIONE_PRIMITIVE")
  private Integer versionePrimitive;
  @OneToMany(
          fetch = FetchType.LAZY,
          mappedBy = "fkStazione"
  )
  private List<PaStazionePa> paStazionePaList;

  @Convert(disableConversion = true)
  @Column(name = "IS_PAYMENT_OPTIONS_ENABLED", nullable = false)
  private Boolean isPaymentOptionsEnabled = false;

  @Column(name = "REST_ENDPOINT")
  private String restEndpoint;
}
