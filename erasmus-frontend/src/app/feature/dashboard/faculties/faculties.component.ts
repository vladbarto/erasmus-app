import { Component, DestroyRef, OnInit } from '@angular/core';
import { takeUntilDestroyed } from '@angular/core/rxjs-interop';
import { Router } from '@angular/router';
import { FacultyService } from '../../../core/service/faculty/faculty.service';
import { FacultyModel } from '../../../shared/models/faculty.model';


@Component({
  selector: 'app-faculties', templateUrl: './faculties.component.html', styleUrl: './faculties.component.scss',
})
export class FacultiesComponent implements OnInit {

  faculties: FacultyModel[] = [];

  constructor(
    private facultyService: FacultyService,
    private router: Router,
    private destroyRef: DestroyRef
  ) {
  }

  ngOnInit(): void {
    this.getFaculties();
  }

  searchAll() {
    this.facultyService.getAll()
      .pipe(takeUntilDestroyed(this.destroyRef))
      .subscribe(response => this.faculties = response);
  }

  deleteFacultyCalled(facultyId: string): void {
    console.log('Deleting faculty ', facultyId);
      this.facultyService.deleteById(facultyId)
        .pipe(takeUntilDestroyed(this.destroyRef))
        .subscribe(
          () => {
            // Optionally, you can update the faculties list after deletion
            this.getFaculties();
          },
          error => {
            console.error('Error deleting faculty: ', error);
            // Handle error appropriately
          }
        );
  }

  addFaculty(faculty: FacultyModel) {
    console.log(faculty);
    this.facultyService
        .insert(faculty)
        .subscribe( (faculty) => this.faculties.push(faculty) );
  }

  logOut(): void {
    this.clearCookies();
    localStorage.removeItem('loggedUser');
    this.router.navigateByUrl('/auth/login');
  }

  private getFaculties(): void {
    this.facultyService.getAll()
      .pipe(takeUntilDestroyed(this.destroyRef))
      .subscribe({
        next: response => this.faculties = response, error: err => console.log(err),
      });
  }

  private clearCookies(): void {
    const cookies = document.cookie.split(';');
    for (let i = 0; i < cookies.length; i++) {
      const cookie = cookies[i];
      const equalPos = cookie.indexOf('=');
      const name = equalPos > -1 ? cookie.slice(0, equalPos) : cookie;
      document.cookie = name + '=;expires=Thu, 01 Jan 1970 00:00:00 GMT;path=/;';
    }
  }
}
