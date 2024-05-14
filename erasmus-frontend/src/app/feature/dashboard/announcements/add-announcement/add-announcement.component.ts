import { Component, DestroyRef, OnInit, Output, EventEmitter } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { AnnouncementService } from '../../../../core/service/announcement/announcement.service';
import { takeUntilDestroyed } from '@angular/core/rxjs-interop';
import { AnnouncementModel } from '../../../../shared/models/announcement.model';

@Component({
  selector: 'app-add-announcement',
  templateUrl: './add-announcement.component.html',
  styleUrl: './add-announcement.component.css'
})
export class AddAnnouncementComponent implements OnInit {
  @Output() onAddAnnouncement = new EventEmitter<AnnouncementModel>();
  addAnnouncementForm: FormGroup = new FormGroup({});

  constructor(
    private formBuilder: FormBuilder,
    private announcementService: AnnouncementService,
    private destroyRef: DestroyRef
  ) {}

  ngOnInit(): void {
    this.buildAddAnnouncementForm();
  }

  onSubmit(): void {
      const newAnnouncement = {
        title: this.addAnnouncementForm?.get('title')?.value,
        universityCode: this.addAnnouncementForm?.get('universityCode')?.value,
        representativeId: this.addAnnouncementForm?.get('representativeId')?.value,
        description: this.addAnnouncementForm?.get('description')?.value
      };

    this.onAddAnnouncement.emit(newAnnouncement);
  }

  private buildAddAnnouncementForm(): void {
    this.addAnnouncementForm = this.formBuilder.group({
      title: [''],
      universityCode: [''],
      description: [''],
      representativeId: ['']
    });
  }
}
