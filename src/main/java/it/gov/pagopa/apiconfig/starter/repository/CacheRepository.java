package it.gov.pagopa.apiconfig.starter.repository;

import it.gov.pagopa.apiconfig.starter.entity.Cache;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CacheRepository extends PagingAndSortingRepository<Cache, Long> {

  Optional<Cache> findFirstByVersion(String version, Sort by);

  @Query("select c.id, c.version from Cache c")
  List<Cache> findAll();

  Page<Cache> findAll(Pageable pageable);

  Page<Cache> findByVersionLike(String versionLike, Pageable pageable);
}
