import { Routes } from '@angular/router';
import { Home } from './home/home';
import { EmployesList } from './employes-list/employes-list';
import { EmployeAdd } from './employe-add/employe-add';
import { EmployeUpdate } from './employe-update/employe-update';

export const routes: Routes = [
     { path: '', component: EmployesList },
     { path: 'employes', component: EmployesList },
     { path: 'employes/add', component: EmployeAdd },
     { path: 'employes/update/:id', component: EmployeUpdate },
];



