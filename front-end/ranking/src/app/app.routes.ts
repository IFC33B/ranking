import { Routes } from '@angular/router';
import { LlistaCandidats } from './components/llista-candidats/llista-candidats';

export const routes: Routes = [
    { path: '', redirectTo: '/candidats', pathMatch: 'full' },
    { path: 'candidats', component: LlistaCandidats },
    // { path: 'formulari', component: FormulariProductes }
];
