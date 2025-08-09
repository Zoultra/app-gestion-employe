import { Component } from '@angular/core';
import { Employe } from '../models/employe';
import { EmployeService } from '../services/employe.service';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employes-list',
    standalone: true,
  imports: [CommonModule],
  templateUrl: './employes-list.html',
  styleUrl: './employes-list.scss'
})
export class EmployesList {

  

   id!: number;
   employes: Employe[] = [];
  errorMsg: string = '';

  constructor(private employeService: EmployeService, private router: Router) {}

  ngOnInit(): void {
    this.loadEmployes();
  }

  loadEmployes(): void {
    this.employeService.getEmployes().subscribe({
      next: (data) => this.employes = data,
      error: (err) => this.errorMsg = "Erreur lors du chargement des employés : " + err.message
    });
  }

  goToUpdateEmploye(id: number) {  
    this.router.navigate(['/employes/update/', id]);   
  }

   deleteEmploye(id: number) {
    if (confirm('Voulez-vous vraiment supprimer cet employé ?')) {
      this.employeService.deleteEmploye(id).subscribe(() => {
        this.loadEmployes(); // 🔄 Recharge la liste après suppression
      });
    }
  }

}
