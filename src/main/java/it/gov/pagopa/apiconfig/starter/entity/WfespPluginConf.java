package it.gov.pagopa.apiconfig.starter.entity;

import java.io.Serializable;
import jakarta.persistence.Column;
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
@Table(name = "WFESP_PLUGIN_CONF")
@Builder(toBuilder = true)
public class WfespPluginConf implements Serializable {

  private static final long serialVersionUID = 5816769493432162073L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
  @SequenceGenerator(
      name = "hibernate_sequence",
      sequenceName = "hibernate_sequence",
      allocationSize = 1)
  @Column(name = "OBJ_ID", nullable = false)
  private Long id;

  @Column(name = "ID_SERV_PLUGIN", nullable = false, length = 35)
  private String idServPlugin;

  @Column(name = "PROFILO_PAG_CONST_STRING", length = 150)
  private String profiloPagConstString;

  @Column(name = "PROFILO_PAG_SOAP_RULE", length = 150)
  private String profiloPagSoapRule;

  @Column(name = "PROFILO_PAG_RPT_XPATH", length = 150)
  private String profiloPagRptXpath;

  @Column(name = "ID_BEAN")
  private String idBean;
}
