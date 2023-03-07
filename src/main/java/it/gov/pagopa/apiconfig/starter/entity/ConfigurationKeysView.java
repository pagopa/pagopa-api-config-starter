package it.gov.pagopa.apiconfig.starter.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ConfigurationKeysView implements Serializable {

  @Id
  @Column(name = "CONFIG_CATEGORY", nullable = false)
  private String configCategory;

  @Id
  @Column(name = "CONFIG_KEY", nullable = false)
  private String configKey;
}
