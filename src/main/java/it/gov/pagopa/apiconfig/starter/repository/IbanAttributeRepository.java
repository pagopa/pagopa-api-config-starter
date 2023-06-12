package it.gov.pagopa.apiconfig.starter.repository;

import it.gov.pagopa.apiconfig.starter.entity.IbanAttribute;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IbanAttributeRepository extends JpaRepository<IbanAttribute, Long> {

  public List<IbanAttribute> findByObjIdIn(List<Long> objId);
}
