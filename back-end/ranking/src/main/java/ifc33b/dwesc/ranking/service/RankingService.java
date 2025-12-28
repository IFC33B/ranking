package ifc33b.dwesc.ranking.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifc33b.dwesc.ranking.dto.CandidatResponse;
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
}
