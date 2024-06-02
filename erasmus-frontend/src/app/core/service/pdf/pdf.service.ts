import { Injectable } from '@angular/core';
import {UserModel} from "../../../shared/models/user.model";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {PdfModel} from "../../../shared/models/pdf.model";

@Injectable({
  providedIn: 'root'
})
export class PdfService {

  constructor(private http: HttpClient) { }

  generate(pdfRequest: PdfModel): Observable<PdfModel> {
    return this.http.post<PdfModel>(`pdf/v1/generator`, pdfRequest);
  }
}
