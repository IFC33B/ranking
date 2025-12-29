package ifc33b.dwesc.ranking.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CandidatRequest {
    // Atributos
    @NotBlank(message = "Se requiere un nombre para el candidato")
    private String nom;

    // Constructores
   public CandidatRequest(String nom) {
        this.setNom(nom);
    }
}
