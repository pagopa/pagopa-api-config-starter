package it.gov.pagopa.apiconfig.starter.repository;

import it.gov.pagopa.apiconfig.starter.entity.Iban;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IbanRepository extends JpaRepository<Iban, Long> {

  Optional<Iban> findByIban(String iban);

  List<Iban> findByObjIdIn(List<Long> ids);
}