import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {DashboardRoutingModule} from "./dashboard-routing.module";
import { FacultyComponent } from './faculty/faculty.component';
import { FacultiesComponent } from './faculties/faculties.component';
import { FacultyCardComponent } from './faculties/faculty-card/faculty-card.component';



@NgModule({
  declarations: [
    FacultyComponent,
    FacultiesComponent,
    FacultyCardComponent
  ],
  imports: [
    CommonModule,
    DashboardRoutingModule
  ]
})
export class DashboardModule { }
