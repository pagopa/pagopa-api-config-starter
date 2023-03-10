package it.gov.pagopa.apiconfig.starter.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

@Table(name = "CDI_DETAIL")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class CdiDetail {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
  @SequenceGenerator(
      name = "hibernate_sequence",
      sequenceName = "hibernate_sequence",
      allocationSize = 1)
  @Column(name = "OBJ_ID", nullable = false)
  private Long id;

  @Column(name = "NOME_SERVIZIO")
  private String nomeServizio;

  @Column(name = "PRIORITA", nullable = false)
  private Long priorita;

  @Column(name = "MODELLO_PAGAMENTO", nullable = false)
  private Long modelloPagamento;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "FK_CDI_MASTER", nullable = false)
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  private CdiMaster cdiMaster;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "FK_PSP_CANALE_TIPO_VERSAMENTO", nullable = false)
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  private PspCanaleTipoVersamentoCanale pspCanaleTipoVersamento;

  @Column(name = "CANALE_APP")
  private Long canaleApp;

  @Column(name = "TAGS", length = 135)
  private String tags;

  @Column(name = "LOGO_SERVIZIO")
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  private byte[] logoServizio;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "cdiDetail", cascade = CascadeType.REMOVE)
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  private List<CdiInformazioniServizio> cdiInformazioniServizio;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "cdiDetail", cascade = CascadeType.REMOVE)
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  private List<CdiFasciaCostoServizio> cdiFasciaCostoServizio;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "cdiDetail", cascade = CascadeType.REMOVE)
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  private List<CdiPreference> cdiPreference;
}
