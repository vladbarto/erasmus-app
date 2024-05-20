import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {RepresentativeModel} from '../../../shared/models/representative.model';
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class RepresentativeService {

  constructor(private http: HttpClient) {}

  insert(representative: RepresentativeModel): Observable<RepresentativeModel> {
    return this.http.post<RepresentativeModel>(`representative/v1/one`, representative);
  }
}
