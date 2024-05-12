import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {DashboardRoutingModule} from "./dashboard-routing.module";
import { FacultyComponent } from './faculty/faculty.component';
import { FacultiesComponent } from './faculties/faculties.component';
import { FacultyCardComponent } from './faculties/faculty-card/faculty-card.component';
import { AddFacultyComponent } from './faculties/add-faculty/add-faculty.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { UpdateFacultyComponent } from './faculty/update-faculty/update-faculty.component';


@NgModule({
  declarations: [
    FacultyComponent,
    FacultiesComponent,
    FacultyCardComponent,
    AddFacultyComponent,
    UpdateFacultyComponent
  ],
  imports: [
    CommonModule,
    DashboardRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class DashboardModule { }
