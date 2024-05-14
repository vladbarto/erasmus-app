import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-all-done',
  templateUrl: './all-done.component.html',
  styleUrl: './all-done.component.css'
})
export class AllDoneComponent {

  constructor(private router: Router) {}

  ngOnInit() {
    setTimeout(() => {
            this.router.navigateByUrl('auth/login');
        }, 3000);  //3s
  }

}
