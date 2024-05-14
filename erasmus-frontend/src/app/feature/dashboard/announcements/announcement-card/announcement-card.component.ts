import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Router } from '@angular/router';
import { AnnouncementModel } from '../../../../shared/models/announcement.model';

@Component({
  selector: 'app-announcement-card',
  templateUrl: './announcement-card.component.html',
  styleUrl: './announcement-card.component.css'
})
export class AnnouncementCardComponent {
  @Input() announcement!: AnnouncementModel;
  @Output() deleteAnnouncement: EventEmitter<string> = new EventEmitter<string>();

  constructor(private router: Router) {
  }

  viewDetails(announcementId: string): void {
    this.router.navigate([ '/dashboard/announcement/' + announcementId ]);
  }

  deleteAnnouncementPressed(announcementId: string): void {
    this.deleteAnnouncement.emit(announcementId);
  }
}
