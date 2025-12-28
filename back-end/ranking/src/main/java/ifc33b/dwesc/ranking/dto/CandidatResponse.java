package ifc33b.dwesc.ranking.dto;

import ifc33b.dwesc.ranking.model.Candidat;
import lombok.Data;

@Data
public class CandidatResponse {
    // Atributos
    Long id;
    String nom;
    Integer vots;

    // Constructores
    public CandidatResponse(Candidat candidat) {
        this.setId(candidat.getId());
        this.setNom(candidat.getNom());
        this.setVots(candidat.getVots());
    }
}
