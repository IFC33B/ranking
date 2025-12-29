import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit, signal } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { CandidatService } from '../../services/candidat.service';
import { RouterLink } from "@angular/router";

@Component({
  selector: 'app-formulari-candidats',
  imports: [FormsModule, ReactiveFormsModule],
  templateUrl: './formulari-candidats.html',
  styleUrl: './formulari-candidats.css',
})
export class FormulariCandidats implements OnInit {
  carregant = signal(false);
  error = signal<HttpErrorResponse | null>(null);

  // Formulario reactivo
  candidatForm!: FormGroup;

  constructor(private candidatService: CandidatService) { }

  ngOnInit(): void {
    // Campos del formulario
    this.candidatForm = new FormGroup({
      nom: new FormControl('', [Validators.required, Validators.minLength(3)])
    })
  }

  // Añadir candidato
  afegirCandidats() {
    this.carregant.set(true);
    this.error.set(null);

    if (this.candidatForm.valid) {

      // Service
      this.candidatService.createCandidat(this.candidatForm.value).subscribe({
        next: (data) => {
          this.carregant.set(false);
          this.candidatForm.reset();
        },

        error: (err) => {
          this.error.set(err);
          this.carregant.set(false);
          console.log(err);
        }
      })
    } else {
      alert("Datos inválidos")
    }
  }

  // Recargar página
  reload() {
    window.location.reload()
  }
}
