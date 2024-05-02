import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Router } from '@angular/router';
import { FacultyModel } from '../../../../shared/models/faculty.model';


@Component({
  selector: 'app-faculty-card',
  templateUrl: './faculty-card.component.html',
  styleUrl: './faculty-card.component.css'
})
export class FacultyCardComponent {

  @Input() faculty!: FacultyModel;
  @Output() deleteFaculty: EventEmitter<string> = new EventEmitter<string>();

  constructor(private router: Router) {
  }

  viewDetails(facultyId: string): void {
    this.router.navigate([ '/dashboard/faculty/' + facultyId ]);
  }

  deleteFacultyPressed(facultyId: string): void {
    this.deleteFaculty.emit(facultyId);
  }
}
