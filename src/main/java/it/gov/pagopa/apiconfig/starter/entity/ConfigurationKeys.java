package it.gov.pagopa.apiconfig.starter.entity;

import java.io.Serializable;
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

@IdClass(ConfigurationKeysView.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@Entity
@Table(name = "CONFIGURATION_KEYS")
@Builder(toBuilder = true)
public class ConfigurationKeys implements Serializable {

  private static final long serialVersionUID = -7800388408390622190L;

  @Id
  @Column(name = "CONFIG_CATEGORY", nullable = false, length = 255)
  private String configCategory;

  @Id
  @Column(name = "CONFIG_KEY", nullable = false, length = 255)
  private String configKey;

  @Column(name = "CONFIG_VALUE", nullable = false, length = 255)
  private String configValue;

  @Column(name = "CONFIG_DESCRIPTION", length = 255)
  private String configDescription;
}
