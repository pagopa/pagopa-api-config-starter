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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@Entity
@Table(name = "PDD")
@Builder(toBuilder = true)
public class Pdd implements Serializable {

  private static final long serialVersionUID = 4814819547556565354L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
  @SequenceGenerator(
      name = "hibernate_sequence",
      sequenceName = "hibernate_sequence",
      allocationSize = 1)
  @Column(name = "OBJ_ID", nullable = false)
  private Long id;

  @Column(name = "ID_PDD", nullable = false, length = 35)
  private String idPdd;

  @Convert(converter = YesNoConverter.class)
  @Column(name = "ENABLED", nullable = false)
  private Boolean enabled;

  @Column(name = "descrizione", nullable = false, length = 35)
  private String descrizione;

  @Column(name = "IP", nullable = false, length = 15)
  private String ip;

  @Column(name = "porta")
  private Integer porta;
}
