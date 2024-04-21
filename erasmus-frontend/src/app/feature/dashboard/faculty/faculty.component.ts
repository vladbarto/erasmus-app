import { Component } from '@angular/core';
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

  constructor(private route: ActivatedRoute, private facultyService: FacultyService) {
  }

  ngOnInit(): void {
    this.route.params.subscribe(response => {
      this.facultyId = response['id'];

      this.facultyService.getById(this.facultyId || '')
        .subscribe(response => this.faculty = response);
    });
  }
}
