import { Routes } from '@angular/router';
import { Home } from './home/home';
import { EmployesList } from './employes-list/employes-list';
import { EmployeAdd } from './employe-add/employe-add';
import { EmployeUpdate } from './employe-update/employe-update';
import { Authentification } from './authentification/authentification';

 

export const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: Authentification },
  { path: 'home', component: Home },
  { path: 'employes/update/:id', component: EmployeUpdate },
  { path: 'employes', component: EmployesList },
  { path: 'employes/add', component: EmployeAdd },
  { path: '**', redirectTo: 'login' }
];



