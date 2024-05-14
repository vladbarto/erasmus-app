import { Component, DestroyRef, OnInit, Output, EventEmitter } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { BareSubjectService } from '../../../../core/service/bare-subject/bare-subject.service';
import { takeUntilDestroyed } from '@angular/core/rxjs-interop';
import { BareSubjectModel } from '../../../../shared/models/bare-subject.model';
@Component({
  selector: 'app-update-bare-subject',
  templateUrl: './update-bare-subject.component.html',
  styleUrl: './update-bare-subject.component.css'
})

export class UpdateBareSubjectComponent {
    @Output() onUpdateBareSubject = new EventEmitter<BareSubjectModel>();
    updateBareSubjectForm: FormGroup = new FormGroup({});

    constructor(
      private formBuilder: FormBuilder,
      private bareSubjectService: BareSubjectService,
      private destroyRef: DestroyRef
    ) {}

    ngOnInit(): void {
      this.buildUpdateBareSubjectForm();
    }

    private buildUpdateBareSubjectForm(): void {
      this.updateBareSubjectForm = this.formBuilder.group({
        compositeKey: [''],
        description: [''],
        CAENSubject: 0
      });
    }

    onSubmit() {
      const newBareSubject = {
        compositeKey: this.updateBareSubjectForm?.get('compositeKey')?.value,
        CAENSubject: this.updateBareSubjectForm?.get('CAENSubject')?.value,
        description: this.updateBareSubjectForm?.get('description')?.value
      };

      this.onUpdateBareSubject.emit(newBareSubject);
    }
}
