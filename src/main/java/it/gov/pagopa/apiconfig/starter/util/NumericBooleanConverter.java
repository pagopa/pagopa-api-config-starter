package it.gov.pagopa.apiconfig.starter.util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class NumericBooleanConverter implements AttributeConverter<Boolean, Integer> {

  @Override
  public Integer convertToDatabaseColumn(final Boolean value) {
    return Boolean.TRUE.equals(value) ? 1 : 0;
  }

  @Override
  public Boolean convertToEntityAttribute(final Integer value) {
    return value != null && value.equals(1);
  }
}
