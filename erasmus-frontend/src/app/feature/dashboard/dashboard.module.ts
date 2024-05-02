import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {DashboardRoutingModule} from "./dashboard-routing.module";
import { FacultyComponent } from './faculty/faculty.component';
import { FacultiesComponent } from './faculties/faculties.component';
import { FacultyCardComponent } from './faculties/faculty-card/faculty-card.component';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    FacultyComponent,
    FacultiesComponent,
    FacultyCardComponent
  ],
  imports: [
    CommonModule,
    DashboardRoutingModule,
    FormsModule
  ]
})
export class DashboardModule { }
