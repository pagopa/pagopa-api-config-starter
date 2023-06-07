package it.gov.pagopa.apiconfig.starter.entity;

import lombok.*;
import org.springframework.data.annotation.Immutable;

import javax.persistence.*;

@Table(name = "IBAN_ATTRIBUTES")
@Entity
@Immutable
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class IbanAttributes {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
  @SequenceGenerator(
      name = "hibernate_sequence",
      sequenceName = "hibernate_sequence",
      allocationSize = 1)
  @Column(name = "OBJ_ID")
  private Long objId;

  @Column(name = "ATTRIBUTE_NAME", nullable = false)
  private String attributeName;

  @Column(name = "ATTRIBUTE_DESCRIPTION", nullable = false)
  private String attributeDescription;
}
