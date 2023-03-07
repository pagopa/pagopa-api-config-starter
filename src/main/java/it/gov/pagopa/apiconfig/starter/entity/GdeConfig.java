package it.gov.pagopa.apiconfig.starter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "GDE_CONFIG")
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@IdClass(GdeConfigPk.class)
public class GdeConfig {

  @Id
  @Column(name = "PRIMITIVA", nullable = false)
  private String primitiva;

  @Column(name = "TYPE", nullable = false)
  private String type;

  @Column(name = "EVENT_HUB")
  private Boolean eventHubEnabled;

  @Column(name = "EVENT_HUB_PAYLOAD")
  private Boolean eventHubPayloadEnabled;
}
