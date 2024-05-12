import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {FacultyModel} from '../../../shared/models/faculty.model';
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class FacultyService {

  constructor(private http: HttpClient) {
  }

  getById(facultyId: string): Observable<FacultyModel> {
    return this.http.get<FacultyModel>(`faculty/v1/${facultyId}`);
  }

  getAll(): Observable<FacultyModel[]> {
      return this.http.get<FacultyModel[]>('faculty/v1/all', {
        params: { }
      });
   }

  deleteById(facultyId: string): Observable<FacultyModel> {
      return this.http.delete<FacultyModel>(`faculty/v1/${facultyId}`)
   }

  insert(faculty: FacultyModel): Observable<FacultyModel> {
      return this.http.post<FacultyModel>(`faculty/v1/one`, faculty);
  }

  update(faculty: FacultyModel, facultyId: string): Observable<FacultyModel> {
      return this.http.put<FacultyModel>(`faculty/v1/${facultyId}`, faculty);
  }


//   getAll(rating: number = 0): Observable<ChefModel[]> {
//     return this.http.get<ChefModel[]>('chef/v1/all3', {
//       params: {
//         rating
//       }
//     });
//  }
}
