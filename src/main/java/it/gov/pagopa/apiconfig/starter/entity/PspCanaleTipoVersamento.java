package it.gov.pagopa.apiconfig.starter.entity;

import java.io.Serializable;
import javax.persistence.Column;
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

@Entity
@Table(name = "PSP_CANALE_TIPO_VERSAMENTO")
@Setter
@Getter
@ToString
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PspCanaleTipoVersamento implements Serializable {

  private static final long serialVersionUID = -5372621010851688463L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
  @SequenceGenerator(
      name = "hibernate_sequence",
      sequenceName = "hibernate_sequence",
      allocationSize = 1)
  @Column(name = "OBJ_ID", nullable = false)
  private Long id;

  @Column(
      name = "FK_CANALE_TIPO_VERSAMENTO",
      nullable = false,
      insertable = false,
      updatable = false)
  private Long fkCanaleTipoVersamento;

  @Column(name = "FK_PSP", nullable = false, insertable = false, updatable = false)
  private Long fkPsp;

  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "FK_CANALE_TIPO_VERSAMENTO", nullable = false)
  private CanaleTipoVersamento canaleTipoVersamento;

  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "FK_PSP", nullable = false)
  private Psp psp;
}
