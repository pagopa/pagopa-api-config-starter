package it.gov.pagopa.apiconfig.starter.entity;

import lombok.*;
import org.springframework.data.annotation.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.List;

@Table(name = "ICA_BINARY_FILE")
@Entity
@Immutable
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class IcaBinaryFile {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
  @SequenceGenerator(
      name = "hibernate_sequence",
      sequenceName = "hibernate_sequence",
      allocationSize = 1)
  @Column(name = "OBJ_ID")
  private Long objId;

  @Column(name = "FILE_CONTENT", nullable = false)
  @ToString.Exclude
  private byte[] fileContent;

  @Column(name = "FILE_HASH", nullable = false)
  @ToString.Exclude
  private byte[] fileHash;

  @Column(name = "FILE_SIZE", nullable = false)
  private Long fileSize;

  @ToString.Exclude
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "fkIcaBinaryFile")
  @EqualsAndHashCode.Exclude
  private List<IbanMaster> ibanMasters;
}
