import {NgModule} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {NotFoundComponent} from "../../shared/components/not-found/not-found.component";
import {FacultiesComponent} from "./faculties/faculties.component";
import {FacultyComponent} from "./faculty/faculty.component";


export const routes: Routes = [
  {
    path: 'faculties',
    component: FacultiesComponent
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
