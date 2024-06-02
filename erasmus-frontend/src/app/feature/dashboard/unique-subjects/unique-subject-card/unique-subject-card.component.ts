import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Router } from '@angular/router';
import { UniqueSubjectModel } from '../../../../shared/models/unique-subject.model';

@Component({
  selector: 'app-unique-subject-card',
  templateUrl: './unique-subject-card.component.html',
  styleUrl: './unique-subject-card.component.css'
})

export class UniqueSubjectCardComponent {
  @Input() uniqueSubject!: UniqueSubjectModel;
  @Output() deleteUniqueSubject: EventEmitter<string> = new EventEmitter<string>();

  constructor(private router: Router) {
  }

  viewDetails(uniqueSubjectId: string): void {
    this.router.navigate([ '/dashboard/unique-subject/' + uniqueSubjectId ]);
  }

  deleteUniqueSubjectPressed(uniqueSubjectId: string): void {
    this.deleteUniqueSubject.emit(uniqueSubjectId);
  }

  saveToLocalStorage(event: any): void {
    const checkbox: HTMLInputElement = document.querySelector('#checkbox-select')!;
    if(checkbox.checked) {
      localStorage.setItem("desiredSubject", JSON.stringify(this.uniqueSubject));
    }
    else {
      localStorage.removeItem("desiredSubject");
    }
  }
}
