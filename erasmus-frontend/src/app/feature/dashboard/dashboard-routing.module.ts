import {NgModule} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {NotFoundComponent} from "../../shared/components/not-found/not-found.component";
import {FacultiesComponent} from "./faculties/faculties.component";
import {FacultyComponent} from "./faculty/faculty.component";
import {HomeComponent} from "./home/home.component";
import {AnnouncementsComponent} from "./announcements/announcements.component";
import {AnnouncementComponent} from "./announcement/announcement.component";
import {BareSubjectsComponent} from "./bare-subjects/bare-subjects.component";
import {BareSubjectComponent} from "./bare-subject/bare-subject.component";
import {UniqueSubjectsComponent} from "./unique-subjects/unique-subjects.component";
import {UniqueSubjectComponent} from "./unique-subject/unique-subject.component";

export const routes: Routes = [
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'announcements',
    component: AnnouncementsComponent
  },
  {
    path: 'announcement/:id',
    component: AnnouncementComponent
  },
  {
    path: 'faculties',
    component: FacultiesComponent
  },
  {
    path: 'faculty/:id',
    component: FacultyComponent
  },
  {
    path: 'bare-subjects',
    component: BareSubjectsComponent
  },
  {
    path: 'bare-subject/:id',
    component: BareSubjectComponent
  },
  {
    path: 'unique-subjects',
    component: UniqueSubjectsComponent
  },
  {
    path: 'unique-subject/:id',
    component: UniqueSubjectComponent
  },
  {
    path: '**',
    component: NotFoundComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DashboardRoutingModule {
}
