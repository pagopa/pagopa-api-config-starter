package it.gov.pagopa.apiconfig.starter.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.Immutable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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

  @Column(name = "DUE_DATE", nullable = false)
  private Timestamp dueDate;

  @Column(name = "DESCRIPTION")
  @Comment("Not currently involved in business logic. For future use.")
  @Builder.Default
  private String description = "iban";

  @ToString.Exclude
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "fkIban")
  @EqualsAndHashCode.Exclude
  private List<IbanMaster> ibanMasters;
}
