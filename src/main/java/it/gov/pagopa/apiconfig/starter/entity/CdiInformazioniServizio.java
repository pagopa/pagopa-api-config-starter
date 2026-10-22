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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@Entity
@Table(name = "CDI_INFORMAZIONI_SERVIZIO")
public class CdiInformazioniServizio {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
  @SequenceGenerator(
      name = "hibernate_sequence",
      sequenceName = "hibernate_sequence",
      allocationSize = 1)
  @Column(name = "OBJ_ID", nullable = false)
  private Long id;

  @Column(name = "CODICE_LINGUA", nullable = false, length = 2)
  private String codiceLingua;

  @Column(name = "DESCRIZIONE_SERVIZIO", nullable = false, length = 140)
  private String descrizioneServizio;

  @Column(name = "DISPONIBILITA_SERVIZIO", nullable = false, length = 140)
  private String disponibilitaServizio;

  @Column(name = "URL_INFORMAZIONI_CANALE")
  private String urlInformazioniCanale;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "FK_CDI_DETAIL", nullable = false)
  @ToString.Exclude
  private CdiDetail fkCdiDetail;

  @Column(name = "LIMITAZIONI_SERVIZIO", length = 140)
  private String limitazioniServizio;
}
