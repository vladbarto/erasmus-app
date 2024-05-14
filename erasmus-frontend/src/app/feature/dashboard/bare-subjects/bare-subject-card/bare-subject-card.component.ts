import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Router } from '@angular/router';
import { BareSubjectModel } from '../../../../shared/models/bare-subject.model';

@Component({
  selector: 'app-bare-subject-card',
  templateUrl: './bare-subject-card.component.html',
  styleUrl: './bare-subject-card.component.css'
})

export class BareSubjectCardComponent {
  @Input() bareSubject!: BareSubjectModel;
  @Output() deleteBareSubject: EventEmitter<string> = new EventEmitter<string>();

  constructor(private router: Router) {
  }

  viewDetails(bareSubjectId: string): void {
    this.router.navigate([ '/dashboard/bare-subject/' + bareSubjectId ]);
  }

  deleteBareSubjectPressed(bareSubjectId: string): void {
    this.deleteBareSubject.emit(bareSubjectId);
  }
}
