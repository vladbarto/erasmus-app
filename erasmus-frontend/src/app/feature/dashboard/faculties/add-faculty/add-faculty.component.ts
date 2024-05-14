import { Component, DestroyRef, OnInit, Output, EventEmitter } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { FacultyService } from '../../../../core/service/faculty/faculty.service';
import { takeUntilDestroyed } from '@angular/core/rxjs-interop';
import { FacultyModel } from '../../../../shared/models/faculty.model';

@Component({
  selector: 'app-add-faculty',
  templateUrl: './add-faculty.component.html',
  styleUrl: './add-faculty.component.css'
})
export class AddFacultyComponent implements OnInit {
  @Output() onAddFaculty = new EventEmitter<FacultyModel>();
  addFacultyForm: FormGroup = new FormGroup({});

  constructor(
    private formBuilder: FormBuilder,
    private facultyService: FacultyService,
    private destroyRef: DestroyRef
  ) {}

  ngOnInit(): void {
    this.buildAddFacultyForm();
  }

  onSubmit(): void {
      const newFaculty = {
        name: this.addFacultyForm?.get('name')?.value,
        universityCode: this.addFacultyForm?.get('universityCode')?.value,
        compositeKey: this.addFacultyForm?.get('compositeKey')?.value,
        description: this.addFacultyForm?.get('description')?.value
      };

    this.onAddFaculty.emit(newFaculty);
  }

  private buildAddFacultyForm(): void {
    this.addFacultyForm = this.formBuilder.group({
      name: [''],
      universityCode: [''],
      description: [''],
      compositeKey: ['']
    });
  }
}
