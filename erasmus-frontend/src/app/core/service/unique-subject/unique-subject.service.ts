import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {UniqueSubjectModel} from '../../../shared/models/unique-subject.model';
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class UniqueSubjectService {

  constructor(private http: HttpClient) { }

  deleteById(id: string): Observable<UniqueSubjectModel> {
    return this.http.delete<UniqueSubjectModel>(`unique-subject/v1/${id}`)
  }

  getById(id: string): Observable<UniqueSubjectModel> {
      return this.http.get<UniqueSubjectModel>(`unique-subject/v1/${id}`);
    }

  getAll(): Observable<UniqueSubjectModel[]> {
      return this.http.get<UniqueSubjectModel[]>('unique-subject/v1/all', {
        params: { }
      });
  }

  insert(uniqueSubject: UniqueSubjectModel): Observable<UniqueSubjectModel> {
      return this.http.post<UniqueSubjectModel>(`unique-subject/v1/one`, uniqueSubject);
  }

  update(uniqueSubject: UniqueSubjectModel, id: string): Observable<UniqueSubjectModel> {
      return this.http.put<UniqueSubjectModel>(`unique-subject/v1/${id}`, uniqueSubject);
  }
}
