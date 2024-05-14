import { Component, DestroyRef, OnInit, Output, EventEmitter } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { AnnouncementService } from '../../../../core/service/announcement/announcement.service';
import { takeUntilDestroyed } from '@angular/core/rxjs-interop';
import { AnnouncementModel } from '../../../../shared/models/announcement.model';

@Component({
  selector: 'app-update-announcement',
  templateUrl: './update-announcement.component.html',
  styleUrl: './update-announcement.component.css'
})
export class UpdateAnnouncementComponent {
    @Output() onUpdateAnnouncement = new EventEmitter<AnnouncementModel>();
    updateAnnouncementForm: FormGroup = new FormGroup({});

    constructor(
      private formBuilder: FormBuilder,
      private announcementService: AnnouncementService,
      private destroyRef: DestroyRef
    ) {}

    ngOnInit(): void {
      this.buildUpdateAnnouncementForm();
    }

    private buildUpdateAnnouncementForm(): void {
      this.updateAnnouncementForm = this.formBuilder.group({
        title: [''],
        universityCode: [''],
        description: [''],
        representativeId: ['']
      });
    }

    onSubmit() {
      const newAnnouncement = {
        title: this.updateAnnouncementForm?.get('title')?.value,
        universityCode: this.updateAnnouncementForm?.get('universityCode')?.value,
        representativeId: this.updateAnnouncementForm?.get('representativeId')?.value,
        description: this.updateAnnouncementForm?.get('description')?.value
      };

      this.onUpdateAnnouncement.emit(newAnnouncement);
    }
}
