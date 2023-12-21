package it.gov.pagopa.apiconfig.starter.repository;

import it.gov.pagopa.apiconfig.starter.entity.Iban;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IbanRepository extends JpaRepository<Iban, Long> {

  Optional<Iban> findByIban(String iban);

  List<Iban> findByObjIdIn(List<Long> ids);

  @Modifying
  @Query("delete from Iban i where i.objId in ?1")
  void deleteByIds(List<Long> ids);
}
