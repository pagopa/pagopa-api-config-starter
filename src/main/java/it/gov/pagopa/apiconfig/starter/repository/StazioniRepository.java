package it.gov.pagopa.apiconfig.starter.repository;

import it.gov.pagopa.apiconfig.starter.entity.Stazioni;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface StazioniRepository extends JpaRepository<Stazioni, Long>, JpaSpecificationExecutor<Stazioni> {

  @Query(value = "SELECT e FROM Stazioni e LEFT JOIN FETCH e.intermediarioPa")
  List<Stazioni> findAllFetchingIntermediario();

  Optional<Stazioni> findByIdStazione(String stationCode);

  @Query(
      value =
          "select distinct s from Stazioni s, PaStazionePa r where (:fkIntermediario is null or"
              + " s.fkIntermediarioPa = :fkIntermediario) and (r.fkPa = :fkPa and r.fkStazione = s)"
              + " and (:idStazione is null or upper(s.idStazione) like concat('%',"
              + " upper(:idStazione), '%')) "
              + " AND (cast(cast(:createDateBefore as text) as timestamp) IS NULL OR s.dataCreazione < cast(cast(:createDateBefore as text) as timestamp)) "
              + " AND (cast(cast(:createDateAfter as text) as timestamp) IS NULL OR s.dataCreazione > cast(cast(:createDateAfter as text) as timestamp)) "
              + " AND ((:connectionType IS NULL OR :connectionType = 'NONE') "
              + " OR (:connectionType = 'SYNC' AND servizio LIKE '%gpd%')"
              + " OR (:connectionType = 'ASYNC' AND (servizio IS NULL or servizio NOT LIKE '%gpd%')))")
  Page<Stazioni> findAllByFilters(
      @Param("fkIntermediario") Long fkIntermediario,
      @Param("fkPa") Long fkPa,
      @Param("idStazione") String idStazione,
      @Param("createDateBefore") OffsetDateTime createDateBefore,
      @Param("createDateAfter") OffsetDateTime createDateAfter,
      @Param("connectionType") String connectionType,
      Pageable pageable);

  @Query(
      value =
          "select distinct s from Stazioni s where (:fkIntermediario is null or s.fkIntermediarioPa"
              + " = :fkIntermediario) and (:idStazione is null or upper(s.idStazione) like"
              + " concat('%', upper(:idStazione), '%')) "
              + " AND (cast(cast(:createDateBefore as text) as timestamp) IS NULL OR s.dataCreazione < cast(cast(:createDateBefore as text) as timestamp)) "
              + " AND (cast(cast(:createDateAfter as text) as timestamp) IS NULL OR s.dataCreazione > cast(cast(:createDateAfter as text) as timestamp)) "
              + " AND ((:connectionType IS NULL OR :connectionType = 'NONE') "
              + " OR (:connectionType = 'SYNC' AND servizio LIKE '%gpd%')"
              + " OR (:connectionType = 'ASYNC' AND (servizio IS NULL or servizio NOT LIKE '%gpd%')))")
  Page<Stazioni> findAllByFilters(
      @Param("fkIntermediario") Long fkIntermediario,
      @Param("idStazione") String idStazione,
      @Param("createDateBefore") OffsetDateTime createDateBefore,
      @Param("createDateAfter") OffsetDateTime createDateAfter,
      @Param("connectionType") String connectionType,
      Pageable pageable);

  @Query(
      value =
          "select distinct s from Stazioni s, PaStazionePa r, IntermediariPa i where"
              + " (:fkIntermediario is null or s.fkIntermediarioPa = :fkIntermediario) and (r.fkPa"
              + " = :fkPa and r.fkStazione = s) and (s.intermediarioPa = i) and (:idStazione is"
              + " null or upper(s.idStazione) like concat('%', upper(:idStazione), '%')) and"
              + " (:codiceIntermediario is null or upper(i.codiceIntermediario) like concat('%',"
              + " upper(:codiceIntermediario), '%')) "
              + " AND (cast(cast(:createDateBefore as text) as timestamp) IS NULL OR s.dataCreazione < cast(cast(:createDateBefore as text) as timestamp)) "
              + " AND (cast(cast(:createDateAfter as text) as timestamp) IS NULL OR s.dataCreazione > cast(cast(:createDateAfter as text) as timestamp)) "
              + " AND ((:connectionType IS NULL OR :connectionType = 'NONE') "
              + " OR (:connectionType = 'SYNC' AND servizio LIKE '%gpd%')"
              + " OR (:connectionType = 'ASYNC' AND (servizio IS NULL or servizio NOT LIKE '%gpd%')))")
  Page<Stazioni> findAllByFilters(
      @Param("fkIntermediario") Long fkIntermediario,
      @Param("fkPa") Long fkPa,
      @Param("idStazione") String idStazione,
      @Param("codiceIntermediario") String codiceIntermediario,
      @Param("createDateBefore") OffsetDateTime createDateBefore,
      @Param("createDateAfter") OffsetDateTime createDateAfter,
      @Param("connectionType") String connectionType,
      Pageable pageable);

  @Query(
      value =
          "select distinct s from Stazioni s, IntermediariPa i where (s.intermediarioPa = i) and"
              + " (:fkIntermediario is null or s.fkIntermediarioPa = :fkIntermediario) and"
              + " (:idStazione is null or upper(s.idStazione) like concat('%', upper(:idStazione),"
              + " '%')) and (:codiceIntermediario is null or upper(i.codiceIntermediario) like "
              + " concat('%', upper(:codiceIntermediario), '%')) "
              + " AND (cast(cast(:createDateBefore as text) as timestamp) IS NULL OR s.dataCreazione < cast(cast(:createDateBefore as text) as timestamp)) "
              + " AND (cast(cast(:createDateAfter as text) as timestamp) IS NULL OR s.dataCreazione > cast(cast(:createDateAfter as text) as timestamp)) "
              + " AND ((:connectionType IS NULL OR :connectionType = 'NONE') "
              + " OR (:connectionType = 'SYNC' AND servizio LIKE '%gpd%')"
              + " OR (:connectionType = 'ASYNC' AND (servizio IS NULL or servizio NOT LIKE '%gpd%')))"
  )
  Page<Stazioni> findAllByFilters(
      @Param("fkIntermediario") Long fkIntermediario,
      @Param("idStazione") String idStazione,
      @Param("codiceIntermediario") String codiceIntermediario,
      @Param("createDateBefore") OffsetDateTime createDateBefore,
      @Param("createDateAfter") OffsetDateTime createDateAfter,
      @Param("connectionType") String connectionType,
      Pageable pageable);

  @Query(
      value =
          "select distinct s from Stazioni s where (s.fkIntermediarioPa = :fkIntermediario) order"
              + " by s.idStazione")
  Page<Stazioni> findAllByFiltersOrderById(
      @Param("fkIntermediario") Long fkIntermediario, Pageable pageable);

  @Query(
      value =
          "select distinct s from Stazioni s where (:fkIntermediario is null or s.fkIntermediarioPa"
              + " = :fkIntermediario) and (:idStazione is null or upper(s.idStazione) like"
              + " concat('%', upper(:idStazione), '%')) order by s.idStazione")
  Page<Stazioni> findAllByFiltersOrderById(
      @Param("fkIntermediario") Long fkIntermediario,
      @Param("idStazione") String idStazione,
      Pageable pageable);
}
