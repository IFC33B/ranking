package ifc33b.dwesc.ranking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ifc33b.dwesc.ranking.dto.CandidatRequest;
import ifc33b.dwesc.ranking.dto.CandidatResponse;
import ifc33b.dwesc.ranking.service.RankingService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/candidats")
public class RankingController {
    @Autowired
    private RankingService rankingService;

    @GetMapping() // Devuelve todos los candidatos
    public ResponseEntity<List<CandidatResponse>> getAllCandidats() {
        // Service
        List<CandidatResponse> response = rankingService.getAllCandidats();

        // HTTP Response
        return ResponseEntity.ok(response);
    }

    @PostMapping() // Crea un nuevo candidato
    public ResponseEntity<CandidatResponse> createCandidat(@Valid @RequestBody CandidatRequest request) {
        // Service
        CandidatResponse response = rankingService.createCandidat(request);

        // HTTP Response
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/votar") // Votar a un candidato
    public ResponseEntity<CandidatResponse> voteCandidat(@PathVariable Long id) {
        // Service
        CandidatResponse response = rankingService.voteCandidat(id);

        // HTTP Response
        return ResponseEntity.ok(response);
    }
}
