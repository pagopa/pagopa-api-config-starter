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
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "CDS_SERVIZIO")
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CdsServizio {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
  @SequenceGenerator(
      name = "hibernate_sequence",
      sequenceName = "hibernate_sequence",
      allocationSize = 1)
  @Column(name = "OBJ_ID", nullable = false)
  private Long id;

  @Column(name = "ID_SERVIZIO", nullable = false)
  private String idServizio;

  @Column(name = "DESCRIZIONE_SERVIZIO")
  private String descrizioneServizio;

  @Column(name = "XSD_RIFERIMENTO", nullable = false)
  private String xsdRiferimento;

  @Column(name = "VERSIONE", nullable = false)
  private Long version;

  @Column(name = "CATEGORIA_ID", nullable = false, insertable = false, updatable = false)
  private Long categoriaId;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "CATEGORIA_ID", nullable = false)
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  private CdsCategoria categoria;
}
