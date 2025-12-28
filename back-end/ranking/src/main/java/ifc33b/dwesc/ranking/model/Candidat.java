package ifc33b.dwesc.ranking.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name = "candidat")
public class Candidat {
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Se requiere un nombre para el candidato")
    private String nom;

    @Column(nullable = false)
    @NotNull(message = "Los votos no pueden estar vacios")
    private Integer vots;

    // Constructores
    Candidat() {}

    public Candidat(String nom) {
        this.setNom(nom);
        this.setVots(0);
    }
}
