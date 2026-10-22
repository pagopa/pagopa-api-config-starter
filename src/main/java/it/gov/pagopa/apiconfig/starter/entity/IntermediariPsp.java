package it.gov.pagopa.apiconfig.starter.entity;

import it.gov.pagopa.apiconfig.starter.util.YesNoConverter;
import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "INTERMEDIARI_PSP")
@Entity
@Getter
@Setter
@ToString
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class IntermediariPsp implements Serializable {

  private static final long serialVersionUID = 7011053855758000652L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
  @SequenceGenerator(
      name = "hibernate_sequence",
      sequenceName = "hibernate_sequence",
      allocationSize = 1)
  @Column(name = "OBJ_ID", nullable = false)
  private Long objId;

  @Column(name = "ID_INTERMEDIARIO_PSP", nullable = false, length = 35)
  private String idIntermediarioPsp;

  @Convert(converter = YesNoConverter.class)
  @Column(name = "ENABLED", nullable = false)
  private Boolean enabled;

  @Column(name = "CODICE_INTERMEDIARIO")
  private String codiceIntermediario;

  @Convert(converter = YesNoConverter.class)
  @Column(name = "FAULT_BEAN_ESTESO", nullable = false)
  private Boolean faultBeanEsteso;
}
