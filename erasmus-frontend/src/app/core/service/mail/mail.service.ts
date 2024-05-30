import { Injectable } from '@angular/core';
import {UserModel} from "../../../shared/models/user.model";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {MailModel} from "../../../shared/models/mail.model";

@Injectable({
  providedIn: 'root'
})
export class MailService {

  constructor(private http: HttpClient) { }

  sendMail(mailRequest: MailModel): Observable<MailModel> {
    return this.http.post<MailModel>(`mail/v1/async`, mailRequest);
  }
}
