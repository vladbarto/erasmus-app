import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {UserModel} from '../../../shared/models/user.model';
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class DetailsService {

  credentials: UserModel = {
    username: '',
    password: '',
    email: '',
    role: ''
  };

  constructor(private http: HttpClient) {}

  sendUserForm(credentials: UserModel): void {
    this.credentials = credentials;
    console.log(this.credentials);
  }

  receiveUserForm(): UserModel {
    return this.credentials;
  }
}
