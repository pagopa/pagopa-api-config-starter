package it.gov.pagopa.apiconfig.starter.repository;

import it.gov.pagopa.apiconfig.starter.entity.TipiVersamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TipiVersamentoRepository extends JpaRepository<TipiVersamento, Long> {

  Optional<TipiVersamento> findByTipoVersamento(String tipoVersamento);
}
