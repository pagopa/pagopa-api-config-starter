package it.gov.pagopa.apiconfig.starter.repository;

import it.gov.pagopa.apiconfig.starter.entity.Psp;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@SuppressWarnings("java:S100")
// Disabled naming convention rule for method name to use Spring Data interface
@Repository
public interface PspRepository extends JpaRepository<Psp, Long> {

  Optional<Psp> findByIdPsp(String id);

  Page<Psp>
  findAllByPspCanaleTipoVersamentoList_canale_fkIntermediarioPsp_idIntermediarioPsp(
      String brokerCode, Pageable pageable);
}
