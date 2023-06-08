package it.gov.pagopa.apiconfig.starter.entity;

import lombok.*;
import org.springframework.data.annotation.Immutable;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Table(name = "IBAN_MASTER")
@Entity
@Immutable
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class IbanMaster {

  public enum IbanStatus {
    ENABLED,
    DISABLED
  }

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
  @SequenceGenerator(
      name = "hibernate_sequence",
      sequenceName = "hibernate_sequence",
      allocationSize = 1)
  @Column(name = "OBJ_ID")
  private Long objId;

  @Column(name = "FK_PA", nullable = false)
  private Long fkPa;

  @Column(name = "FK_IBAN", nullable = false)
  private Long fkIban;

  @Column(name = "FK_ICA_BINARY_FILE", nullable = false)
  private Long fkIcaBinaryFile;

  @Column(name = "STATE", nullable = false)
  @Enumerated(EnumType.STRING)
  private IbanStatus ibanStatus;

  @Column(name = "INSERTED_DATE", nullable = false)
  private Timestamp insertedDate;

  @Column(name = "VALIDITY_DATE", nullable = false)
  private Timestamp validityDate;

  @ManyToOne(fetch = FetchType.EAGER, optional = false)
  @JoinColumn(name = "FK_PA", nullable = false)
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  private Pa pa;

  @ManyToOne(fetch = FetchType.EAGER, optional = false)
  @JoinColumn(name = "FK_IBAN", nullable = false)
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  private Iban iban;

  @ManyToOne(fetch = FetchType.EAGER, optional = false)
  @JoinColumn(name = "FK_ICA_BINARY_FILE", nullable = false)
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  private IcaBinaryFile icaBinaryFile;

  @ToString.Exclude
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "fkIbanMaster")
  @EqualsAndHashCode.Exclude
  private List<IbanAttributeMaster> ibanAttributesMasters;
}
