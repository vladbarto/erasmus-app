import { Component, DestroyRef, OnInit } from '@angular/core';
import { takeUntilDestroyed } from '@angular/core/rxjs-interop';
import { ActivatedRoute } from '@angular/router';
import { BareSubjectService } from "../../../core/service/bare-subject/bare-subject.service";
import { BareSubjectModel } from '../../../shared/models/bare-subject.model';

@Component({
  selector: 'app-bare-subject',
  templateUrl: './bare-subject.component.html',
  styleUrl: './bare-subject.component.css'
})

export class BareSubjectComponent {
  bareSubject?: BareSubjectModel;
  bareSubjectId?: string;

  constructor(
    private route: ActivatedRoute,
    private bareSubjectService: BareSubjectService,
    private destroyRef: DestroyRef
  ) {
  }

  ngOnInit(): void {
    this.getBareSubjectById();
  }

  private getBareSubjectById(): void {
      this.route.params
        .pipe(takeUntilDestroyed(this.destroyRef))
        .subscribe(response => {
          this.bareSubjectId = response['id'];

          this.bareSubjectService.getById(this.bareSubjectId || '')
            .pipe(takeUntilDestroyed(this.destroyRef))
            .subscribe(response => this.bareSubject = response);
        });
    }

  updateBareSubject(bareSubject: BareSubjectModel) {
    this.bareSubjectService
        .update(bareSubject, this.bareSubjectId!)
        .subscribe();
    window.location.reload();
  }
}
