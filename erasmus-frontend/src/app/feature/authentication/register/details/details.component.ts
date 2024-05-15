import { Component, DestroyRef, OnInit } from '@angular/core';
import { takeUntilDestroyed } from '@angular/core/rxjs-interop';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { DetailsService } from '../../../../core/service/details/details.service';
import { UserService } from '../../../../core/service/user/user.service';
import { StudentService } from '../../../../core/service/student/student.service';
import { UserModel } from '../../../../shared/models/user.model';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrl: './details.component.css'
})
export class DetailsComponent {
  addUserForm: FormGroup = new FormGroup({});
  showStudentForm: boolean = false;
  showRepresentativeForm: boolean = false;
  credentials: UserModel = {
      username: '',
      password: '',
      email: '',
      role: ''
    };
  errorMessage?: string;

  ngOnInit(): void {
    this.buildAddUserForm();
  }

  constructor(
    private formBuilder: FormBuilder,
    private detailsService: DetailsService,
    private userService: UserService,
    private studentService: StudentService,
    private destroyRef: DestroyRef,
    private router: Router
  ) {

    this.credentials = detailsService.receiveUserForm();

    if (this.credentials.role === 'STUDENT') {
      this.showStudentForm = true;
      this.showRepresentativeForm = false;
      this.credentials.role = 'USER';
    } else {
      this.showStudentForm = false;
      this.showRepresentativeForm = true;
      this.credentials.role = 'ADMIN';
    }

    this.userService.register(this.credentials)
        .pipe(takeUntilDestroyed(this.destroyRef))
        .subscribe({
          error: () => this.errorMessage = 'Invalid credentials'
        });
  }

  private buildAddUserForm(): void {
    this.addUserForm = this.formBuilder.group({
      user: {},
      cnp: [''],
      name: [''],
      phoneNumber: [''],
      dateOfBirth: [''],
      universityCode: [''],
      facultyCode: [''],
      country: [''],
      city: [''],
      matriculationNumber: 0,
      yearOfStudy: 0,
      hasLanguageCertificate: false,
      gpa: 0.0,
      hasReexaminations: false
    });
  }

  onUserSubmit(): void {
    const newUser = {
        userId: '2e2f3ad2-8799-4bb3-8389-4e572099bf7f', // to be deleted
        name: this.addUserForm?.get('name')?.value,
        cnp: this.addUserForm?.get('cnp')?.value,
        phoneNumber: this.addUserForm?.get('phoneNumber')?.value,
        dateOfBirth: this.addUserForm?.get('dateOfBirth')?.value,
        universityCode: this.addUserForm?.get('universityCode')?.value,
        facultyCode: this.addUserForm?.get('facultyCode')?.value,
        country: this.addUserForm?.get('country')?.value,
        city: this.addUserForm?.get('city')?.value,
        matriculationNumber: this.addUserForm?.get('matriculationNumber')?.value,
        yearOfStudy: this.addUserForm?.get('yearOfStudy')?.value,
        hasLanguageCertificate: this.addUserForm?.get('hasLanguageCertificate')?.value,
        gpa: this.addUserForm?.get('gpa')?.value,
        hasReexaminations: this.addUserForm?.get('hasReexaminations')?.value
      };

    //const credentials = localStorage.getItem(JSON.parse('credentials'));

    /*
    const allData = {
        ...credentials,
        ...newUser
      };
    this.studentService.save(allData);
*/
    this.studentService.insert(newUser);
    console.log(newUser);
    this.router.navigateByUrl('auth/register/all-done');
  }
}
