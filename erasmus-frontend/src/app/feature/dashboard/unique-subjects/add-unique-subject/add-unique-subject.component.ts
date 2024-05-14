import { Component, DestroyRef, OnInit, Output, EventEmitter } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { UniqueSubjectService } from '../../../../core/service/unique-subject/unique-subject.service';
import { takeUntilDestroyed } from '@angular/core/rxjs-interop';
import { UniqueSubjectModel } from '../../../../shared/models/unique-subject.model';

@Component({
  selector: 'app-add-unique-subject',
  templateUrl: './add-unique-subject.component.html',
  styleUrl: './add-unique-subject.component.css'
})

export class AddUniqueSubjectComponent implements OnInit {
  @Output() onAddUniqueSubject = new EventEmitter<UniqueSubjectModel>();
  addUniqueSubjectForm: FormGroup = new FormGroup({});

  constructor(
    private formBuilder: FormBuilder,
    private uniqueSubjectService: UniqueSubjectService,
    private destroyRef: DestroyRef
  ) {}

  ngOnInit(): void {
    this.buildAddUniqueSubjectForm();
  }

  onSubmit(): void {
      const newUniqueSubject = {
        universityCode: this.addUniqueSubjectForm?.get('compositeKey')?.value,
        facultyCode: this.addUniqueSubjectForm?.get('facultyCode')?.value,
        CAENSubject: this.addUniqueSubjectForm?.get('CAENSubject')?.value,
        ECTSCredits: this.addUniqueSubjectForm?.get('ECTSCredits')?.value,
        name: this.addUniqueSubjectForm?.get('name')?.value,
        subjectStudyYear: this.addUniqueSubjectForm?.get('subjectStudyYear')?.value
      };

    this.onAddUniqueSubject.emit(newUniqueSubject);
  }

  private buildAddUniqueSubjectForm(): void {
    this.addUniqueSubjectForm = this.formBuilder.group({
      universityCode: [''],
      facultyCode: [''],
      CAENSubject: 0,
      ECTSCredits: 0,
      name: [''],
      subjectStudyYear: 0
    });
  }
}
