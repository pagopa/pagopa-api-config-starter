package it.gov.pagopa.apiconfig.starter.entity;

import java.io.Serializable;
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
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "PSP_CANALE_TIPO_VERSAMENTO_CANALE")
@Setter
@Getter
@ToString
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PspCanaleTipoVersamentoCanale implements Serializable {

  private static final long serialVersionUID = -5055253522275600014L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
  @SequenceGenerator(
      name = "hibernate_sequence",
      sequenceName = "hibernate_sequence",
      allocationSize = 1)
  @Column(name = "OBJ_ID", nullable = false)
  private Long id;

  @Column(name = "FK_CANALE", nullable = false, insertable = false, updatable = false)
  private Long fkCanale;

  @Column(name = "FK_PSP", nullable = false, insertable = false, updatable = false)
  private Long fkPsp;

  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "FK_TIPO_VERSAMENTO", nullable = false)
  @EqualsAndHashCode.Exclude
  private TipiVersamento tipoVersamento;

  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "FK_PSP", nullable = false)
  @EqualsAndHashCode.Exclude
  private Psp psp;

  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "FK_CANALE", nullable = false)
  @EqualsAndHashCode.Exclude
  private CanaliView canale;
}
