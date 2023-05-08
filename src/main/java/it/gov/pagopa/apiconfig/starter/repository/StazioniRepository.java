package it.gov.pagopa.apiconfig.starter.repository;

import it.gov.pagopa.apiconfig.starter.entity.Stazioni;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StazioniRepository extends JpaRepository<Stazioni, Long> {

  @Query(value = "SELECT e FROM Stazioni e LEFT JOIN FETCH e.intermediarioPa")
  List<Stazioni> findAllFetchingIntermediario();

  Optional<Stazioni> findByIdStazione(String stationCode);

  @Query(
      value =
          "select distinct s from Stazioni s, PaStazionePa r where (:fkIntermediario is null or"
              + " s.fkIntermediarioPa = :fkIntermediario) and (r.fkPa = :fkPa and r.fkStazione = s)"
              + " and (:idStazione is null or upper(s.idStazione) like concat('%',"
              + " upper(:idStazione), '%')) ")
  Page<Stazioni> findAllByFilters(
      @Param("fkIntermediario") Long fkIntermediario,
      @Param("fkPa") Long fkPa,
      @Param("idStazione") String idStazione,
      Pageable pageable);

  @Query(
      value =
          "select distinct s from Stazioni s where (:fkIntermediario is null or s.fkIntermediarioPa"
              + " = :fkIntermediario) and (:idStazione is null or upper(s.idStazione) like"
              + " concat('%', upper(:idStazione), '%')) ")
  Page<Stazioni> findAllByFilters(
      @Param("fkIntermediario") Long fkIntermediario,
      @Param("idStazione") String idStazione,
      Pageable pageable);

  @Query(value = "select distinct s from Stazioni s where (:fkIntermediario = :fkIntermediario)")
  Page<Stazioni> findAllByFilter(
      @Param("fkIntermediario") Long fkIntermediario,
      Pageable pageable
  );
}
