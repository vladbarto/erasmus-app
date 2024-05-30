import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-current-user',
  templateUrl: './current-user.component.html',
  styleUrl: './current-user.component.css'
})
export class CurrentUserComponent {

  ngOnInit() {
    console.log(localStorage.getItem('loggedUser'));
  }
}
