import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { Candidat, CandidatRequest } from '../models';

@Injectable({
  providedIn: 'root',
})
export class CandidatService {
  private apiURL = 'http://localhost:8080/api/candidats'

  constructor(private http: HttpClient) {};

  // Obtener todos los candidatos
  getAllCandidats(): Observable<Candidat[]> {
    return this.http.get<Candidat[]>(this.apiURL)
      .pipe(
        catchError(this.handleError)
      )
  }

  // Crear un candidato
  createCandidat(request: CandidatRequest): Observable<Candidat> {
    return this.http.post<Candidat>(this.apiURL, request)
      .pipe(
        catchError(this.handleError)
      )
  }

  // Votar a un candidat
  voteCandidat(id: number): Observable<Candidat> {
    return this.http.put<Candidat>(`${this.apiURL}/${id}`, {})
      .pipe(
        catchError(this.handleError)
      )
  }

  // Gestión de errores
  private handleError(error: HttpErrorResponse) {
    let errorMessage = 'Error desconocido';

    if (error.error instanceof ErrorEvent) {
      // Error del cliente
      errorMessage = `Error: ${error.error.message}`
    } else {
      // Error del servidor
      errorMessage = `Codigo de error: ${error.status}, Mensaje: ${error.message}`;
    }

    console.log(errorMessage);
    return throwError(() => ({
      status: error.status,
      message: errorMessage,
      error: error.error
    }))
  }
}
