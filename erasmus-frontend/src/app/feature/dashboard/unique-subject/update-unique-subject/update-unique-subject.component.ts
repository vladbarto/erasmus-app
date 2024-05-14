import { Component, DestroyRef, OnInit, Output, EventEmitter } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { UniqueSubjectService } from '../../../../core/service/unique-subject/unique-subject.service';
import { takeUntilDestroyed } from '@angular/core/rxjs-interop';
import { UniqueSubjectModel } from '../../../../shared/models/unique-subject.model';
@Component({
  selector: 'app-update-unique-subject',
  templateUrl: './update-unique-subject.component.html',
  styleUrl: './update-unique-subject.component.css'
})

export class UpdateUniqueSubjectComponent {
    @Output() onUpdateUniqueSubject = new EventEmitter<UniqueSubjectModel>();
    updateUniqueSubjectForm: FormGroup = new FormGroup({});

    constructor(
      private formBuilder: FormBuilder,
      private uniqueSubjectService: UniqueSubjectService,
      private destroyRef: DestroyRef
    ) {}

    ngOnInit(): void {
      this.buildUpdateUniqueSubjectForm();
    }

    private buildUpdateUniqueSubjectForm(): void {
      this.updateUniqueSubjectForm = this.formBuilder.group({
        universityCode: [''],
        facultyCode: [''],
        CAENSubject: 0,
        ECTSCredits: 0,
        name: [''],
        subjectStudyYear: 0
      });
    }

    onSubmit() {
      const newUniqueSubject = {
        universityCode: this.updateUniqueSubjectForm?.get('compositeKey')?.value,
        facultyCode: this.updateUniqueSubjectForm?.get('facultyCode')?.value,
        CAENSubject: this.updateUniqueSubjectForm?.get('CAENSubject')?.value,
        ECTSCredits: this.updateUniqueSubjectForm?.get('ECTSCredits')?.value,
        name: this.updateUniqueSubjectForm?.get('name')?.value,
        subjectStudyYear: this.updateUniqueSubjectForm?.get('subjectStudyYear')?.value
      };

      this.onUpdateUniqueSubject.emit(newUniqueSubject);
    }
}
