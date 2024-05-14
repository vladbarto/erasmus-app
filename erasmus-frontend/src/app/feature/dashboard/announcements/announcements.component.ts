import { Component, DestroyRef, OnInit } from '@angular/core';
import { takeUntilDestroyed } from '@angular/core/rxjs-interop';
import { Router } from '@angular/router';
import { AnnouncementService } from '../../../core/service/announcement/announcement.service';
import { AnnouncementModel } from '../../../shared/models/announcement.model';

@Component({
  selector: 'app-announcements',
  templateUrl: './announcements.component.html',
  styleUrl: './announcements.component.css'
})
export class AnnouncementsComponent implements OnInit{

  announcements: AnnouncementModel[] = [];

  constructor(
    private announcementService: AnnouncementService,
    private router: Router,
    private destroyRef: DestroyRef
  ) {
  }

  ngOnInit(): void {
    this.getAnnouncements();
  }

  private getAnnouncements(): void {
      this.announcementService.getAll()
        .pipe(takeUntilDestroyed(this.destroyRef))
        .subscribe({
          next: response => this.announcements = response, error: err => console.log(err),
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

  deleteAnnouncementCalled(announcementId: string): void {
      console.log('Deleting announcement ', announcementId);
        this.announcementService.deleteById(announcementId)
          .pipe(takeUntilDestroyed(this.destroyRef))
          .subscribe(
            () => {
              // Optionally, you can update the announcements list after deletion
              this.getAnnouncements();
            },
            error => {
              console.error('Error deleting announcement: ', error);
              // Handle error appropriately
            }
          );
    }

  addAnnouncement(announcement: AnnouncementModel) {
      console.log(announcement);
      this.announcementService
          .insert(announcement)
          .subscribe( (announcement) => this.announcements.push(announcement) );
    }
}
