 


import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeService } from '../services/employe.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-edit-employe',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './employe-update.html',
  styleUrl: './employe-update.scss'
})
export class EmployeUpdate implements OnInit {

  employeForm!: FormGroup;

  employeId!: number;

  constructor(
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private employeService: EmployeService
  ) {}

  ngOnInit(): void {
   this.employeId = Number(this.route.snapshot.paramMap.get('id'));

  this.employeForm = this.fb.group({
    nom: ['', Validators.required],
    prenom: ['', Validators.required],
    poste: ['', Validators.required],
    email: ['', [Validators.required, Validators.email]],
    dateEmbauche: ['', Validators.required]
  });

  const id = this.route.snapshot.paramMap.get('id');
if (id) {
  this.employeService.getEmploye(this.employeId).subscribe(data => {
    this.employeForm.patchValue(data);
  });
}



  }

  onSubmit(): void {
    if (this.employeForm.valid) {
      this.employeService.updateEmploye(this.employeId, this.employeForm.value as any).subscribe(() => {
        this.router.navigate(['/employes']);
      });
    }
  }
}

