package it.gov.pagopa.apiconfig.starter.repository;

import it.gov.pagopa.apiconfig.starter.entity.PaStazionePa;
import java.util.List;
import java.util.Optional;
import javax.persistence.criteria.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@SuppressWarnings(
    "java:S100") // Disabled naming convention rule for method name to use Spring Data interface
@Repository
public interface PaStazionePaRepository
    extends PagingAndSortingRepository<PaStazionePa, Long>, JpaSpecificationExecutor<PaStazionePa> {

  @Query(
      "select distinct(paspa) from PaStazionePa paspa left join fetch paspa.pa left join fetch"
          + " paspa.fkStazione")
  List<PaStazionePa> findAllFetching();

  List<PaStazionePa> findAllByFkPa(Long creditorInstitutionCode);

  List<PaStazionePa> findAllByFkPaAndSegregazione(Long creditorInstitutionCode, Long segregazione);

  List<PaStazionePa> findAllByFkPaAndSegregazioneAndFkStazione_IdStazioneIsNot(
      Long creditorInstitutionCode, Long segregazione, String stationCode);

  List<PaStazionePa> findAllByFkPaAndProgressivo(Long creditorInstitutionCode, Long progressivo);

  List<PaStazionePa> findAllByFkPaAndProgressivoAndFkStazione_IdStazioneIsNot(
      Long creditorInstitutionCode, Long progressivo, String stationCode);

  Optional<PaStazionePa> findAllByFkPaAndFkStazione_ObjId(
      Long creditorInstitutionCode, Long stationCode);

  void deleteByFkPaAndFkStazione_ObjId(Long creditorInstitutionCode, Long stationCode);

  Page<PaStazionePa> findAllByFkStazione_ObjId(Long stationCode, Pageable pageable);

  List<PaStazionePa> findAllByFkStazione_ObjId(Long stationCode);

  Optional<PaStazionePa> findOne(Specification<PaStazionePa> paStazionePa);

  @Override
  List<PaStazionePa> findAll();

  default Optional<PaStazionePa>
      findByFkPaAndFkStazione_ObjIdAndAuxDigitAndBroadcastAndSegregazioneAndProgressivo(
          Long creditorInstitutionCode,
          Long stationCode,
          Long auxDigit,
          Boolean broadcast,
          Long segregationCode,
          Long applicationCode) {
    return findOne(
        search(
            creditorInstitutionCode,
            stationCode,
            auxDigit,
            broadcast,
            segregationCode,
            applicationCode));
  }

  static Specification<PaStazionePa> search(
      Long creditorInstitutionCode,
      Long stationCode,
      Long auxDigit,
      Boolean broadcast,
      Long segregationCode,
      Long applicationCode) {
    return (root, cq, cb) -> {
      Predicate ciPred = cb.equal(root.get("fkPa"), creditorInstitutionCode);
      Predicate stationPred = cb.equal(root.get("fkStazione"), stationCode);
      // predicate to find (0 or null), (1), (2), (3 or null)
      Predicate auxR = cb.equal(root.get("auxDigit"), auxDigit);
      Predicate auxDigitPred =
          auxDigit == 0 || auxDigit == 3 ? cb.or(auxR, cb.isNull(root.get("auxDigit"))) : auxR;
      Predicate broadcastPred = cb.equal(root.get("broadcast"), broadcast);
      Predicate segregationCodePred =
          segregationCode == null
              ? cb.isNull(root.get("segregazione"))
              : cb.equal(root.get("segregazione"), segregationCode);
      Predicate applicationCodePred =
          applicationCode == null
              ? cb.isNull(root.get("progressivo"))
              : cb.equal(root.get("progressivo"), applicationCode);
      return cb.and(
          ciPred,
          stationPred,
          auxDigitPred,
          broadcastPred,
          segregationCodePred,
          applicationCodePred);
    };
  }
}
