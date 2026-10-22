package it.gov.pagopa.apiconfig.starter.entity;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class ConfigurationKeysView implements Serializable {

  private static final long serialVersionUID = -6198929539099423043L;

  @Id
  @Column(name = "CONFIG_CATEGORY", nullable = false)
  private String configCategory;

  @Id
  @Column(name = "CONFIG_KEY", nullable = false)
  private String configKey;
}
