import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {AnnouncementModel} from '../../../shared/models/announcement.model';
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AnnouncementService {

  constructor(private http: HttpClient) { }

  deleteById(announcementId: string): Observable<AnnouncementModel> {
    return this.http.delete<AnnouncementModel>(`announcement/v1/${announcementId}`)
  }

  getById(announcementId: string): Observable<AnnouncementModel> {
      return this.http.get<AnnouncementModel>(`announcement/v1/${announcementId}`);
    }

  getAll(): Observable<AnnouncementModel[]> {
      return this.http.get<AnnouncementModel[]>('announcement/v1/all', {
        params: { }
      });
  }

  insert(announcement: AnnouncementModel): Observable<AnnouncementModel> {
      return this.http.post<AnnouncementModel>(`announcement/v1/one`, announcement);
  }

  update(announcement: AnnouncementModel, announcementId: string): Observable<AnnouncementModel> {
      return this.http.put<AnnouncementModel>(`announcement/v1/${announcementId}`, announcement);
  }
}
