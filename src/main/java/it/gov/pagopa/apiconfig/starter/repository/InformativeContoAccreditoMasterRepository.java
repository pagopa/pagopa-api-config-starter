package it.gov.pagopa.apiconfig.starter.repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.gov.pagopa.apiconfig.starter.entity.InformativeContoAccreditoMaster;

@SuppressWarnings(
    "java:S100") // Disabled naming convention rule for method name to use Spring Data interface
@Repository
public interface InformativeContoAccreditoMasterRepository
    extends JpaRepository<InformativeContoAccreditoMaster, Long> {

  Optional<InformativeContoAccreditoMaster> findByIdInformativaContoAccreditoPaAndFkPa_IdDominio(
      String idIca, String creditorInstitutionCode);

  List<InformativeContoAccreditoMaster>
      findByFkPa_IdDominioAndDataInizioValiditaLessThanOrderByDataInizioValiditaDesc(
          String idDominio, Timestamp now);
}
