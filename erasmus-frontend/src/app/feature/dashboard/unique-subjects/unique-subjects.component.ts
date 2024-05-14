import { Component, DestroyRef, OnInit } from '@angular/core';
import { takeUntilDestroyed } from '@angular/core/rxjs-interop';
import { Router } from '@angular/router';
import { UniqueSubjectService } from '../../../core/service/unique-subject/unique-subject.service';
import { UniqueSubjectModel } from '../../../shared/models/unique-subject.model';

@Component({
  selector: 'app-unique-subjects',
  templateUrl: './unique-subjects.component.html',
  styleUrl: './unique-subjects.component.css'
})

export class UniqueSubjectsComponent implements OnInit{

  uniqueSubjects: UniqueSubjectModel[] = [];

  constructor(
    private uniqueSubjectService: UniqueSubjectService,
    private router: Router,
    private destroyRef: DestroyRef
  ) {
  }

  ngOnInit(): void {
    this.getUniqueSubjects();
  }

  private getUniqueSubjects(): void {
      this.uniqueSubjectService.getAll()
        .pipe(takeUntilDestroyed(this.destroyRef))
        .subscribe({
          next: response => this.uniqueSubjects = response, error: err => console.log(err),
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

  deleteUniqueSubjectCalled(uniqueSubjectId: string): void {
      console.log('Deleting uniqueSubject ', uniqueSubjectId);
        this.uniqueSubjectService.deleteById(uniqueSubjectId)
          .pipe(takeUntilDestroyed(this.destroyRef))
          .subscribe(
            () => {
              // Optionally, you can update the uniqueSubjects list after deletion
              this.getUniqueSubjects();
            },
            error => {
              console.error('Error deleting uniqueSubject: ', error);
              // Handle error appropriately
            }
          );
    }

  addUniqueSubject(uniqueSubject: UniqueSubjectModel) {
      console.log(uniqueSubject);
      this.uniqueSubjectService
          .insert(uniqueSubject)
          .subscribe( (uniqueSubject) => this.uniqueSubjects.push(uniqueSubject) );
    }
}
