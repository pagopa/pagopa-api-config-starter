package it.gov.pagopa.apiconfig.starter.repository;

import it.gov.pagopa.apiconfig.starter.entity.IbanAttributeMaster;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IbanAttributeMasterRepository extends JpaRepository<IbanAttributeMaster, Long> {

  public List<IbanAttributeMaster> findByFkIbanMasterIn(List<Long> fkIbanMaster);
  
  @Modifying
  @Query("delete from IbanAttributeMaster iam where iam.objId in ?1")
  void deleteByIds(List<Long> ids);
}
