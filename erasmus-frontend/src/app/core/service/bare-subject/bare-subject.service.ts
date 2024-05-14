import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BareSubjectModel} from '../../../shared/models/bare-subject.model';
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class BareSubjectService {

  constructor(private http: HttpClient) { }

  deleteById(id: string): Observable<BareSubjectModel> {
    return this.http.delete<BareSubjectModel>(`bare-subject/v1/${id}`)
  }

  getById(id: string): Observable<BareSubjectModel> {
      return this.http.get<BareSubjectModel>(`bare-subject/v1/${id}`);
    }

  getAll(): Observable<BareSubjectModel[]> {
      return this.http.get<BareSubjectModel[]>('bare-subject/v1/all', {
        params: { }
      });
  }

  insert(bareSubject: BareSubjectModel): Observable<BareSubjectModel> {
      return this.http.post<BareSubjectModel>(`bare-subject/v1/one`, bareSubject);
  }

  update(bareSubject: BareSubjectModel, id: string): Observable<BareSubjectModel> {
      return this.http.put<BareSubjectModel>(`bare-subject/v1/${id}`, bareSubject);
  }
}
