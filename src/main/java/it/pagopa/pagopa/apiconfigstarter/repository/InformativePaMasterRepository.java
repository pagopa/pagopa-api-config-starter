package it.pagopa.pagopa.apiconfigstarter.repository;

import it.pagopa.pagopa.apiconfigstarter.entity.InformativePaMaster;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@SuppressWarnings("java:S100") // Disabled naming convention rule for method name to use Spring Data interface
@Repository
public interface InformativePaMasterRepository extends JpaRepository<InformativePaMaster, Long> {

    Optional<InformativePaMaster> findByIdInformativaPaAndFkPa_IdDominio(String idCounterpartTable, String creditorInstitutionCode);

    List<InformativePaMaster> findByFkPa_IdDominioAndDataInizioValiditaLessThanOrderByDataInizioValiditaDesc(String idDominio, Timestamp now);

}
