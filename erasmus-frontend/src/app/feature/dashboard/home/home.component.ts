import { Component, OnInit, DestroyRef } from '@angular/core';
import { Router } from '@angular/router';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MailService} from "../../../core/service/mail/mail.service";
import {MailModel} from "../../../shared/models/mail.model";
import {AnnouncementModel} from "../../../shared/models/announcement.model";
import {takeUntilDestroyed} from "@angular/core/rxjs-interop";
import {AnnouncementService} from "../../../core/service/announcement/announcement.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit{

  mailRequestForm: FormGroup = new FormGroup({});
  status: string = 'x';
  showMail: boolean = false;
  announcements: AnnouncementModel[] = [];

  constructor(
    private router: Router,
    private mailService: MailService,
    private formBuilder: FormBuilder,
    private destroyRef: DestroyRef,
    private announcementService: AnnouncementService
  ) { }

  ngOnInit(): void {
    this.buildMailForm();
    this.getAnnouncements();
  }

  private getAnnouncements(): void {
    this.announcementService.getAll()
      .pipe(takeUntilDestroyed(this.destroyRef))
      .subscribe({
        next: response => this.announcements = response, error: err => console.log(err),
      });
  }

  logOut(): void {
      this.clearCookies();
      localStorage.removeItem('loggedUser');
      this.router.navigateByUrl('/auth/login');
  }

  showMailMethod(): void {
    this.showMail = !this.showMail;
  }

  onSendMail(): void {
    console.log("YAAAY!");

    const newMail: MailModel = {
      to: this.mailRequestForm?.get('to')?.value,
      subject: this.mailRequestForm?.get('subject')?.value,
      body: this.mailRequestForm?.get('body')?.value
    };

    console.log(newMail);
    this.mailService.sendMail(newMail).subscribe();
  }

  private buildMailForm(): void {
    this.mailRequestForm = this.formBuilder.group({
      to: [ '', [ Validators.required ] ],
      subject: [ '' ],
      body: [ '' ]
    });
  }

  hoverOn(): void {
    this.status = 'on';
  }

  hoverOff(): void {
    this.status = 'off';
  }

  currentUser(): void {
    this.router.navigateByUrl('dashboard/current-user');
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
}
