import { Component, DestroyRef, OnInit } from '@angular/core';
import { takeUntilDestroyed } from '@angular/core/rxjs-interop';
import { ActivatedRoute } from '@angular/router';
import { UniqueSubjectService } from "../../../core/service/unique-subject/unique-subject.service";
import { UniqueSubjectModel } from '../../../shared/models/unique-subject.model';

@Component({
  selector: 'app-unique-subject',
  templateUrl: './unique-subject.component.html',
  styleUrl: './unique-subject.component.css'
})

export class UniqueSubjectComponent {
  uniqueSubject?: UniqueSubjectModel;
  uniqueSubjectId?: string;

  constructor(
    private route: ActivatedRoute,
    private uniqueSubjectService: UniqueSubjectService,
    private destroyRef: DestroyRef
  ) {
  }

  ngOnInit(): void {
    this.getUniqueSubjectById();
  }

  private getUniqueSubjectById(): void {
      this.route.params
        .pipe(takeUntilDestroyed(this.destroyRef))
        .subscribe(response => {
          this.uniqueSubjectId = response['id'];

          this.uniqueSubjectService.getById(this.uniqueSubjectId || '')
            .pipe(takeUntilDestroyed(this.destroyRef))
            .subscribe(response => this.uniqueSubject = response);
        });
    }

  updateUniqueSubject(uniqueSubject: UniqueSubjectModel) {
    this.uniqueSubjectService
        .update(uniqueSubject, this.uniqueSubjectId!)
        .subscribe();
    window.location.reload();
  }
}
