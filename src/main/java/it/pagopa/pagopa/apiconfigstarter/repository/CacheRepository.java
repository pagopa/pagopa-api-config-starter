package it.pagopa.pagopa.apiconfigstarter.repository;

import it.pagopa.pagopa.apiconfigstarter.entity.Cache;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CacheRepository extends PagingAndSortingRepository<Cache, Long> {

    Optional<Cache> findFirstByVersion(String version, Sort by);

    @Query("select c.id, c.version from Cache c")
    List<Cache> findAll();

//    @Query("select new it.pagopa.pagopa.apiconfig.model.configuration.Cache(c.id, c.version) from Cache c")
//    Page<it.pagopa.pagopa.apiconfig.model.configuration.Cache> findAllPaged(Pageable pageable);


}
