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
import { BareSubjectsComponent } from './bare-subjects/bare-subjects.component';
import { BareSubjectCardComponent } from './bare-subjects/bare-subject-card/bare-subject-card.component';
import { AddBareSubjectComponent } from './bare-subjects/add-bare-subject/add-bare-subject.component';
import { BareSubjectComponent } from './bare-subject/bare-subject.component';
import { UpdateBareSubjectComponent } from './bare-subject/update-bare-subject/update-bare-subject.component';
import { UniqueSubjectsComponent } from './unique-subjects/unique-subjects.component';
import { UniqueSubjectCardComponent } from './unique-subjects/unique-subject-card/unique-subject-card.component';
import { AddUniqueSubjectComponent } from './unique-subjects/add-unique-subject/add-unique-subject.component';
import { UniqueSubjectComponent } from './unique-subject/unique-subject.component';
import { UpdateUniqueSubjectComponent } from './unique-subject/update-unique-subject/update-unique-subject.component';
import { CurrentUserComponent } from './current-user/current-user.component';

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
    UpdateAnnouncementComponent,
    BareSubjectsComponent,
    BareSubjectCardComponent,
    AddBareSubjectComponent,
    BareSubjectComponent,
    UpdateBareSubjectComponent,
    UniqueSubjectsComponent,
    UniqueSubjectCardComponent,
    AddUniqueSubjectComponent,
    UniqueSubjectComponent,
    UpdateUniqueSubjectComponent,
    CurrentUserComponent,
  ],
  imports: [
    CommonModule,
    DashboardRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class DashboardModule { }
