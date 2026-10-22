package it.gov.pagopa.apiconfig.starter.entity;

import java.time.ZonedDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "CACHE")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@java.lang.SuppressWarnings("java:S1700")
public class Cache {

  @Id
  @Column(name = "ID", nullable = false)
  private String id;

  @Column(name = "CACHE", nullable = false)
  @ToString.Exclude
  private byte[] cache;

  @Column(name = "TIME", nullable = false)
  @ToString.Exclude
  private ZonedDateTime time;

  @Column(name = "VERSION", nullable = false)
  private String version;
}
