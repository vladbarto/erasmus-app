import { Component, DestroyRef, OnInit } from '@angular/core';
import { takeUntilDestroyed } from '@angular/core/rxjs-interop';
import { ActivatedRoute } from '@angular/router';
import { AnnouncementService } from "../../../core/service/announcement/announcement.service";
import { AnnouncementModel } from '../../../shared/models/announcement.model';

@Component({
  selector: 'app-announcement',
  templateUrl: './announcement.component.html',
  styleUrl: './announcement.component.css'
})
export class AnnouncementComponent {
  announcement?: AnnouncementModel;
  announcementId?: string;

  constructor(
    private route: ActivatedRoute,
    private announcementService: AnnouncementService,
    private destroyRef: DestroyRef
  ) {
  }

  ngOnInit(): void {
    this.getAnnouncementById();
  }

  private getAnnouncementById(): void {
      this.route.params
        .pipe(takeUntilDestroyed(this.destroyRef))
        .subscribe(response => {
          this.announcementId = response['id'];

          this.announcementService.getById(this.announcementId || '')
            .pipe(takeUntilDestroyed(this.destroyRef))
            .subscribe(response => this.announcement = response);
        });
    }

  updateAnnouncement(announcement: AnnouncementModel) {
    this.announcementService
        .update(announcement, this.announcementId!)
        .subscribe();
    window.location.reload();
  }
}
