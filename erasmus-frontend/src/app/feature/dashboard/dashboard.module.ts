import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {DashboardRoutingModule} from "./dashboard-routing.module";
import { FacultyComponent } from './faculty/faculty.component';
import { FacultiesComponent } from './faculties/faculties.component';
import { FacultyCardComponent } from './faculties/faculty-card/faculty-card.component';
import { AddFacultyComponent } from './faculties/add-faculty/add-faculty.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { UpdateFacultyComponent } from './faculty/update-faculty/update-faculty.component';
import { HomeComponent } from './home/home.component';
import { AnnouncementsComponent } from './announcements/announcements.component';
import { AnnouncementCardComponent } from './announcements/announcement-card/announcement-card.component';
import { AddAnnouncementComponent } from './announcements/add-announcement/add-announcement.component';
import { AnnouncementComponent } from './announcement/announcement.component';
import { UpdateAnnouncementComponent } from './announcement/update-announcement/update-announcement.component';


@NgModule({
  declarations: [
    FacultyComponent,
    FacultiesComponent,
    FacultyCardComponent,
    AddFacultyComponent,
    UpdateFacultyComponent,
    HomeComponent,
    AnnouncementsComponent,
    AnnouncementCardComponent,
    AddAnnouncementComponent,
    AnnouncementComponent,
    UpdateAnnouncementComponent
  ],
  imports: [
    CommonModule,
    DashboardRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class DashboardModule { }
