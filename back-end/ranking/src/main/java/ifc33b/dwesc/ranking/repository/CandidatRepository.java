package ifc33b.dwesc.ranking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ifc33b.dwesc.ranking.model.Candidat;

@Repository
public interface CandidatRepository extends JpaRepository<Candidat, Long> {}
