import { Component, DestroyRef, OnInit, Output, EventEmitter } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { FacultyService } from '../../../../core/service/faculty/faculty.service';
import { takeUntilDestroyed } from '@angular/core/rxjs-interop';
import { FacultyModel } from '../../../../shared/models/faculty.model';

@Component({
  selector: 'app-update-faculty',
  templateUrl: './update-faculty.component.html',
  styleUrl: './update-faculty.component.css'
})
export class UpdateFacultyComponent {
    @Output() onUpdateFaculty = new EventEmitter<FacultyModel>();
    updateFacultyForm: FormGroup = new FormGroup({});

    constructor(
      private formBuilder: FormBuilder,
      private facultyService: FacultyService,
      private destroyRef: DestroyRef
    ) {}

    ngOnInit(): void {
      this.buildUpdateFacultyForm();
    }

    private buildUpdateFacultyForm(): void {
      this.updateFacultyForm = this.formBuilder.group({
        name: [''],
        universityCode: [''],
        description: [''],
        compositeKey: ['']
      });
    }

    onSubmit() {
      const newFaculty = {
        name: this.updateFacultyForm?.get('name')?.value,
        universityCode: this.updateFacultyForm?.get('universityCode')?.value,
        compositeKey: this.updateFacultyForm?.get('compositeKey')?.value,
        description: this.updateFacultyForm?.get('description')?.value
      };

      this.onUpdateFaculty.emit(newFaculty);
    }
}
