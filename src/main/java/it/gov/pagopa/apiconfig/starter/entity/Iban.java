package it.gov.pagopa.apiconfig.starter.entity;

import lombok.*;
import org.springframework.data.annotation.Immutable;
import javax.persistence.*;
import java.util.List;

@Table(name = "IBAN")
@Entity
@Immutable
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class Iban {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
  @SequenceGenerator(
      name = "hibernate_sequence",
      sequenceName = "hibernate_sequence",
      allocationSize = 1)
  @Column(name = "OBJ_ID")
  private Long objId;

  @Column(name = "IBAN", nullable = false, unique = true)
  private String iban;

  @Column(name = "FISCAL_CODE", nullable = false)
  private String fiscalCode;

  @Column(name = "DESCRIPTION")
  private String description;

  @ToString.Exclude
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "fkIban")
  @EqualsAndHashCode.Exclude
  private List<IbanMaster> ibanMasters;
}
