import { Component, DestroyRef, OnInit } from '@angular/core';
import { takeUntilDestroyed } from '@angular/core/rxjs-interop';
import { ActivatedRoute } from '@angular/router';
import { FacultyService } from "../../../core/service/faculty/faculty.service";
import { FacultyModel } from '../../../shared/models/faculty.model';

@Component({
  selector: 'app-faculty',
  templateUrl: './faculty.component.html',
  styleUrl: './faculty.component.css'
})
export class FacultyComponent {
  faculty?: FacultyModel;
  facultyId?: string;

  constructor(
    private route: ActivatedRoute,
    private facultyService: FacultyService,
    private destroyRef: DestroyRef
  ) {
  }

  ngOnInit(): void {
    this.getFacultyById();
  }

  private getFacultyById(): void {
      this.route.params
        .pipe(takeUntilDestroyed(this.destroyRef))
        .subscribe(response => {
          this.facultyId = response['id'];

          this.facultyService.getById(this.facultyId || '')
            .pipe(takeUntilDestroyed(this.destroyRef))
            .subscribe(response => this.faculty = response);
        });
    }

  updateFaculty(faculty: FacultyModel) {
    this.facultyService
        .update(faculty, this.facultyId!)
        .subscribe();
    window.location.reload();
  }
}
