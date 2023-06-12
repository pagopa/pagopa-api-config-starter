package it.gov.pagopa.apiconfig.starter.entity;

import javax.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Immutable;

@Table(name = "IBAN_ATTRIBUTES_MASTER")
@Entity
@Immutable
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class IbanAttributeMaster {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
  @SequenceGenerator(
      name = "hibernate_sequence",
      sequenceName = "hibernate_sequence",
      allocationSize = 1)
  @Column(name = "OBJ_ID")
  private Long objId;

  @Column(name = "FK_IBAN_MASTER", nullable = false, insertable = false, updatable = false)
  private Long fkIbanMaster;

  @Column(name = "FK_IBAN_ATTRIBUTE", nullable = false, insertable = false, updatable = false)
  private Long fkAttribute;

  @ManyToOne(fetch = FetchType.EAGER, optional = false)
  @JoinColumn(name = "FK_IBAN_MASTER", nullable = false)
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  private IbanMaster ibanMaster;

  @ManyToOne(fetch = FetchType.EAGER, optional = false)
  @JoinColumn(name = "FK_IBAN_ATTRIBUTE", nullable = false)
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  private IbanAttribute ibanAttribute;
}
