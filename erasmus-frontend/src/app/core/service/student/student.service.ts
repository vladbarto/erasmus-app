import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {StudentModel} from '../../../shared/models/student.model';
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  constructor(private http: HttpClient) {}

  insert(student: StudentModel): Observable<StudentModel> {
    return this.http.post<StudentModel>(`student/v1/one`, student);
  }
}
