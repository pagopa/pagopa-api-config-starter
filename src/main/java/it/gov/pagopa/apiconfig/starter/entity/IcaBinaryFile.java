package it.gov.pagopa.apiconfig.starter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.*;
import org.springframework.data.annotation.Immutable;

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

  @Column(name = "ID_DOMINIO", nullable = false)
  private String idDominio;

  @Column(name = "FILE_CONTENT")
  @Lob
  @ToString.Exclude
  private byte[] fileContent;

  @Column(name = "FILE_HASH")
  @Lob
  @ToString.Exclude
  private byte[] fileHash;

  @Column(name = "FILE_SIZE", nullable = false)
  private Long fileSize;
}
