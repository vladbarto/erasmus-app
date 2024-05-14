import { Component, DestroyRef, OnInit, Output, EventEmitter } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { BareSubjectService } from '../../../../core/service/bare-subject/bare-subject.service';
import { takeUntilDestroyed } from '@angular/core/rxjs-interop';
import { BareSubjectModel } from '../../../../shared/models/bare-subject.model';

@Component({
  selector: 'app-add-bare-subject',
  templateUrl: './add-bare-subject.component.html',
  styleUrl: './add-bare-subject.component.css'
})

export class AddBareSubjectComponent implements OnInit {
  @Output() onAddBareSubject = new EventEmitter<BareSubjectModel>();
  addBareSubjectForm: FormGroup = new FormGroup({});

  constructor(
    private formBuilder: FormBuilder,
    private bareSubjectService: BareSubjectService,
    private destroyRef: DestroyRef
  ) {}

  ngOnInit(): void {
    this.buildAddBareSubjectForm();
  }

  onSubmit(): void {
      const newBareSubject = {
        compositeKey: this.addBareSubjectForm?.get('compositeKey')?.value,
        CAENSubject: this.addBareSubjectForm?.get('CAENSubject')?.value,
        description: this.addBareSubjectForm?.get('description')?.value
      };

    this.onAddBareSubject.emit(newBareSubject);
  }

  private buildAddBareSubjectForm(): void {
    this.addBareSubjectForm = this.formBuilder.group({
      compositeKey: [''],
      description: [''],
      CAENSubject: 0
    });
  }
}
