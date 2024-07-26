package it.gov.pagopa.apiconfig.starter.util;

import javax.persistence.AttributeConverter;

/**
 * Dummy converter for boolean values, to deprecate once all entities using the numeric converter are
 * defined without the use of the auto-apply
 */
public class DummyBooleanConverter implements AttributeConverter<Boolean, Boolean> {

  @Override
  public Boolean convertToDatabaseColumn(final Boolean value) {
    return value;
  }

  @Override
  public Boolean convertToEntityAttribute(final Boolean value) {
    return value;
  }

}
