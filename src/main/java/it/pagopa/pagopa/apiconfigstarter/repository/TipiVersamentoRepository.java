package it.pagopa.pagopa.apiconfigstarter.repository;

import it.pagopa.pagopa.apiconfigstarter.entity.TipiVersamento;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipiVersamentoRepository extends JpaRepository<TipiVersamento, Long> {

    Optional<TipiVersamento> findByTipoVersamento(String tipoVersamento);
}
