import { Component, OnInit, DestroyRef } from '@angular/core';
import { UniqueSubjectService } from '../../../core/service/unique-subject/unique-subject.service';
import { UniqueSubjectModel } from '../../../shared/models/unique-subject.model';
import { takeUntilDestroyed } from '@angular/core/rxjs-interop';
import { PdfService } from '../../../core/service/pdf/pdf.service';
import { PdfModel } from '../../../shared/models/pdf.model';

@Component({
  selector: 'app-erasmus-journey',
  templateUrl: './erasmus-journey.component.html',
  styleUrl: './erasmus-journey.component.css'
})
export class ErasmusJourneyComponent implements OnInit{
  uniqueSubjects: UniqueSubjectModel[] = [];

  constructor(
    private uniqueSubjectService: UniqueSubjectService,
    private destroyRef: DestroyRef,
    private pdfService: PdfService
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

  public generatePdf(): void {
    console.log("I am clicked!");
    const pdfRequest: PdfModel = { };

    const currentLoggedString = localStorage.getItem('loggedUser');
    if(currentLoggedString != null) {
      const currentLogged = JSON.parse(currentLoggedString);
      console.log(currentLogged);
    }
    // this.pdfService.generate(pdfRequest);
  }
}
