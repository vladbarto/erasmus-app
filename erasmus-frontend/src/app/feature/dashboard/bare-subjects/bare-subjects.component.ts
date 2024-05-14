import { Component, DestroyRef, OnInit } from '@angular/core';
import { takeUntilDestroyed } from '@angular/core/rxjs-interop';
import { Router } from '@angular/router';
import { BareSubjectService } from '../../../core/service/bare-subject/bare-subject.service';
import { BareSubjectModel } from '../../../shared/models/bare-subject.model';

@Component({
  selector: 'app-bare-subjects',
  templateUrl: './bare-subjects.component.html',
  styleUrl: './bare-subjects.component.css'
})

export class BareSubjectsComponent implements OnInit{

  bareSubjects: BareSubjectModel[] = [];

  constructor(
    private bareSubjectService: BareSubjectService,
    private router: Router,
    private destroyRef: DestroyRef
  ) {
  }

  ngOnInit(): void {
    this.getBareSubjects();
  }

  private getBareSubjects(): void {
      this.bareSubjectService.getAll()
        .pipe(takeUntilDestroyed(this.destroyRef))
        .subscribe({
          next: response => this.bareSubjects = response, error: err => console.log(err),
        });
    }

  private clearCookies(): void {
      const cookies = document.cookie.split(';');
      for (let i = 0; i < cookies.length; i++) {
        const cookie = cookies[i];
        const equalPos = cookie.indexOf('=');
        const name = equalPos > -1 ? cookie.slice(0, equalPos) : cookie;
        document.cookie = name + '=;expires=Thu, 01 Jan 1970 00:00:00 GMT;path=/;';
      }
  }

  deleteBareSubjectCalled(bareSubjectId: string): void {
      console.log('Deleting bareSubject ', bareSubjectId);
        this.bareSubjectService.deleteById(bareSubjectId)
          .pipe(takeUntilDestroyed(this.destroyRef))
          .subscribe(
            () => {
              // Optionally, you can update the bareSubjects list after deletion
              this.getBareSubjects();
            },
            error => {
              console.error('Error deleting bareSubject: ', error);
              // Handle error appropriately
            }
          );
    }

  addBareSubject(bareSubject: BareSubjectModel) {
      console.log(bareSubject);
      this.bareSubjectService
          .insert(bareSubject)
          .subscribe( (bareSubject) => this.bareSubjects.push(bareSubject) );
    }
}
