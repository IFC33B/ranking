package ifc33b.dwesc.ranking.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifc33b.dwesc.ranking.dto.CandidatRequest;
import ifc33b.dwesc.ranking.dto.CandidatResponse;
import ifc33b.dwesc.ranking.exception.CandidatNotFoundException;
import ifc33b.dwesc.ranking.model.Candidat;
import ifc33b.dwesc.ranking.repository.CandidatRepository;

@Service
public class RankingService {
    @Autowired
    CandidatRepository candidatRepository;

    // Devolver todos los candidatos
    public List<CandidatResponse> getAllCandidats() {
        return candidatRepository.findAll().stream()
                .map(CandidatResponse::new)
                .collect(Collectors.toList());
    }

    // Añadir un candidato
    public CandidatResponse createCandidat(CandidatRequest request) {
        Candidat candidat = new Candidat(request.getNom());
        candidatRepository.save(candidat);
        return new CandidatResponse(candidat);
    }

    // Votar a un candidato
    public CandidatResponse voteCandidat(Long id) {
        Candidat candidat = candidatRepository.findById(id)
                .orElseThrow(() -> new CandidatNotFoundException(id));
        
        candidat.votar();
        return new CandidatResponse(candidat);
    }
}
