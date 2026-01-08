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
    DISABLED,
    NA
  }

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
  @SequenceGenerator(
      name = "hibernate_sequence",
      sequenceName = "hibernate_sequence",
      allocationSize = 1)
  @Column(name = "OBJ_ID")
  private Long objId;

  @Column(name = "FK_PA", nullable = false, insertable = false, updatable = false)
  private Long fkPa;

  @Column(name = "FK_IBAN", nullable = false, insertable = false, updatable = false)
  private Long fkIban;

  @Column(name = "STATE", nullable = false)
  @Enumerated(EnumType.STRING)
  @Builder.Default
  private IbanStatus ibanStatus = IbanStatus.NA;

  @Column(name = "INSERTED_DATE", nullable = false)
  private Timestamp insertedDate;

  @Column(name = "VALIDITY_DATE", nullable = false)
  private Timestamp validityDate;

  @Column(name = "DESCRIPTION")
  private String description;

  @Column(name = "DUE_DATE", nullable = false)
  private Timestamp dueDate;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "FK_PA", nullable = false)
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  private Pa pa;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "FK_IBAN", nullable = false)
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  private Iban iban;

  @ToString.Exclude
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "fkIbanMaster", cascade = CascadeType.ALL)
  @EqualsAndHashCode.Exclude
  private List<IbanAttributeMaster> ibanAttributesMasters;
}
