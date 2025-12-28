package ifc33b.dwesc.ranking.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/candidats")
public class RankingController {

    @GetMapping() // Devuelve todos los candidatos
    public int getAllCandidats() {
        return 0;
    }
    
    @PostMapping() // Crea un nuevo candidato
    public int createCandidat() {
        return 0;
    }
    
    @PutMapping("/{id}/votar") // Votar un candidato
    public int voteCandidat(@PathVariable String id) {
        return 0;
    }
}
