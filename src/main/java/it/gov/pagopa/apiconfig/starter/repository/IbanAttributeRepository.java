package it.gov.pagopa.apiconfig.starter.repository;

import it.gov.pagopa.apiconfig.starter.entity.IbanAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IbanAttributeRepository extends JpaRepository<IbanAttribute, Long> {

  public List<IbanAttribute> findByObjIdIn(List<Long> objId);
}
