import { Component, inject } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { EmployeService } from '../services/employe.service';
import { CommonModule } from '@angular/common';
import { Employe } from '../models/employe';

@Component({
  selector: 'app-employe-add',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './employe-add.html',
  styleUrls: ['./employe-add.scss'],
})
export class EmployeAdd {
  private fb = inject(FormBuilder);
  private router = inject(Router);
  private employeService = inject(EmployeService);

  employeForm = this.fb.group({
    nom: ['', Validators.required],
    prenom: ['', Validators.required],
    poste: ['', Validators.required],
    email: ['', [Validators.required, Validators.email]],
    dateEmbauche: ['', Validators.required],
  });

  onSubmit() {
    if (this.employeForm.valid) {
  const employe: Employe = {
    nom: this.employeForm.get('nom')!.value!,
    prenom: this.employeForm.get('prenom')!.value!,
    poste: this.employeForm.get('poste')!.value!,
    email: this.employeForm.get('email')!.value!,
    dateEmbauche: this.employeForm.get('dateEmbauche')!.value!,
  };

  this.employeService.createEmploye(employe).subscribe({
    next: () => this.router.navigate(['/employes']),
    error: (err) => console.error('Erreur création employé:', err),
  });
}

  }
}
