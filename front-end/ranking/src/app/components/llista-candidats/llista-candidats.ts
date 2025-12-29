import { Component, OnInit, signal } from '@angular/core';
import { Candidat } from '../../models';
import { HttpErrorResponse } from '@angular/common/http';
import { CandidatService } from '../../services/candidat.service';

@Component({
  selector: 'app-llista-candidats',
  imports: [],
  templateUrl: './llista-candidats.html',
  styleUrl: './llista-candidats.css',
})
export class LlistaCandidats implements OnInit {
  candidats = signal<Candidat[] | null>(null);
  carregant = signal(false);
  error = signal<HttpErrorResponse | null>(null);

  constructor(private candidatService: CandidatService) { }

  ngOnInit(): void {
    this.carregarCandidats();
  }

  // Cargar candidatos
  carregarCandidats() {
    this.carregant.set(true);
    this.error.set(null);

    // Service
    this.candidatService.getAllCandidats().subscribe({
      next: (data) => {
        this.candidats.set(data);
        this.carregant.set(false);
      },

      error: (err) => {
        this.error.set(err);
        this.carregant.set(false);
        console.log(err);
      }
    })
  }

  // Votar a un candidato
  votarCandidat(id: number) {
    this.carregant.set(true);
    this.error.set(null);

    // Service
    this.candidatService.voteCandidat(id).subscribe({
      next: (data) => {
        this.candidats.update((llista) => {
          if (!llista) return llista;
          
          return llista?.map(c => c.id === data.id ? data : c)
        })
        this.carregant.set(false);
      },

      error: (err) => {
        this.error.set(err);
        this.carregant.set(false);
        console.log(err);
      }
    })
  }
}
