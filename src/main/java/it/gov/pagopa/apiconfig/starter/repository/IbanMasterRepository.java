package it.gov.pagopa.apiconfig.starter.repository;

import it.gov.pagopa.apiconfig.starter.entity.IbanMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IbanMasterRepository extends JpaRepository<IbanMaster, Long> {

  List<IbanMaster> findByFkIban(Long fkIban);

  List<IbanMaster> findByFkIbanAndFkPa(Long fkIban, Long fkPa);

  List<IbanMaster> findByFkPa(Long fkPa);

  @Modifying
  @Query("delete from IbanMaster im where im.objId in ?1")
  void deleteByIds(List<Long> ids);


    @Query("select master from IbanMaster master, IbanAttributeMaster attribute " +
            "where master.objId = attribute.fkIbanMaster " +
            "and master.fkPa=?1 " +
            "and ( ?2=null or attribute.ibanAttribute.attributeName=?2)")
    List<IbanMaster> findByFkPaAndLabel(Long fkPa, String label);
}
