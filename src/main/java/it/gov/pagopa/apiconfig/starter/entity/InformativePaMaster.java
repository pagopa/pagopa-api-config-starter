package it.gov.pagopa.apiconfig.starter.entity;

import java.time.ZonedDateTime;
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

@Table(name = "INFORMATIVE_PA_MASTER")
@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class InformativePaMaster {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
  @SequenceGenerator(name = "hibernate_sequence", sequenceName = "hibernate_sequence", allocationSize = 1)

  @Column(name = "OBJ_ID", nullable = false)
  private Long id;

  @Column(name = "ID_INFORMATIVA_PA", nullable = false, length = 35)
  private String idInformativaPa;

  @Column(name = "DATA_INIZIO_VALIDITA")
  private ZonedDateTime dataInizioValidita;

  @Column(name = "DATA_PUBBLICAZIONE")
  private ZonedDateTime dataPubblicazione;

  @ManyToOne(optional = false)
  @JoinColumn(name = "FK_PA", nullable = false)
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  private Pa pa;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "FK_BINARY_FILE")
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  private BinaryFile binaryFile;

  @Column(name = "VERSIONE", length = 35)
  private String versione;

  @Column(name = "PAGAMENTI_PRESSO_PSP")
  private Boolean pagamentiPressoPsp;


  @OneToMany(fetch = FetchType.LAZY, mappedBy = "informativaPaMaster", cascade = CascadeType.REMOVE)
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  private List<InformativePaDetail> details;
}
