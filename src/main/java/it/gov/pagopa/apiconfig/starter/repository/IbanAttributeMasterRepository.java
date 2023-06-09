package it.gov.pagopa.apiconfig.starter.repository;

import it.gov.pagopa.apiconfig.starter.entity.IbanAttributeMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IbanAttributeMasterRepository extends JpaRepository<IbanAttributeMaster, Long> {

  public List<IbanAttributeMaster> findByFkIbanMasterIn(List<Long> fkIbanMaster);
}
