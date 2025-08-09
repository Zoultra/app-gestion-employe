import { Component, signal } from '@angular/core';
import { Router, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './app.html',
  styleUrls: ['./app.scss']
})
export class App {
  protected readonly title = signal('frontend-employes');
   
  constructor(private router: Router) {}
  
   menuOpen = false;

  toggleMenu() {
    this.menuOpen = !this.menuOpen;
  }

  closeMenu() {
    this.menuOpen = false;
  }

   goToList() {  
    this.router.navigate(['/employes']);   
  }

   goToHome() {  
    this.router.navigate(['/']);   
  }

   goToAddEmploye() {  
    this.router.navigate(['/employes/add']);   
  }

   
}
