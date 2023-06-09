package it.gov.pagopa.apiconfig.starter.repository;

import it.gov.pagopa.apiconfig.starter.entity.IbanMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IbanMasterRepository extends JpaRepository<IbanMaster, Long> {

  List<IbanMaster> findByFkIban(Long fkIban);

  List<IbanMaster> findByFkIbanAndFkPa(Long fkIban, Long fkPa);
}
