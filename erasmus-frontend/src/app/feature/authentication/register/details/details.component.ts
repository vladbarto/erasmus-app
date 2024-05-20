import { Component, DestroyRef, OnInit } from '@angular/core';
import { takeUntilDestroyed } from '@angular/core/rxjs-interop';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { DetailsService } from '../../../../core/service/details/details.service';
import { UserService } from '../../../../core/service/user/user.service';
import { StudentService } from '../../../../core/service/student/student.service';
import { RepresentativeService } from '../../../../core/service/representative/representative.service';
import { UserModel } from '../../../../shared/models/user.model';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrl: './details.component.css'
})
export class DetailsComponent {
  addStudentForm: FormGroup = new FormGroup({});
  addRepresentativeForm: FormGroup = new FormGroup({});
  showStudentForm: boolean = false;
  showRepresentativeForm: boolean = false;
  credentials: UserModel;
  errorMessage?: string;
  representativeType: string;

  ngOnInit(): void {
    this.buildAddStudentForm();
    this.buildAddRepresentativeForm();
  }

  constructor(
    private formBuilder: FormBuilder,
    private detailsService: DetailsService,
    private userService: UserService,
    private studentService: StudentService,
    private representativeService: RepresentativeService,
    private destroyRef: DestroyRef,
    private router: Router
  ) {
    let credentialsString = localStorage.getItem('credentials');
      if (credentialsString) {
        this.credentials = JSON.parse(credentialsString);
        console.log(this.credentials);
        this.representativeType = this.credentials.role;
      } else {
        this.credentials = {'username': '', 'email': '', 'password': '', 'role': ''};
        console.log('No credentials found');
        this.representativeType = '';
      }

    if (this.credentials.role === 'STUDENT') {
      this.showStudentForm = true;
      this.showRepresentativeForm = false;
      this.credentials.role = 'USER';
    } else {
      this.showStudentForm = false;
      this.showRepresentativeForm = true;
      this.credentials.role = 'ADMIN';
    }
  }

  private buildAddStudentForm(): void {
    this.addStudentForm = this.formBuilder.group({
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

  private buildAddRepresentativeForm(): void {
    this.addRepresentativeForm = this.formBuilder.group({
      user: {},
      cnp: [''],
      name: [''],
      phoneNumber: [''],
      dateOfBirth: [''],
      universityCode: [''],
      facultyCode: [''],
      country: [''],
      city: [''],
      titles: [''],
      type: ['']
    });
  }

  onStudentSubmit(): void {
    const newStudent = {
        userId: '',
        name: this.addStudentForm?.get('name')?.value,
        cnp: this.addStudentForm?.get('cnp')?.value,
        phoneNumber: this.addStudentForm?.get('phoneNumber')?.value,
        dateOfBirth: this.addStudentForm?.get('dateOfBirth')?.value,
        universityCode: this.addStudentForm?.get('universityCode')?.value,
        facultyCode: this.addStudentForm?.get('facultyCode')?.value,
        country: this.addStudentForm?.get('country')?.value,
        city: this.addStudentForm?.get('city')?.value,
        matriculationNumber: this.addStudentForm?.get('matriculationNumber')?.value,
        yearOfStudy: this.addStudentForm?.get('yearOfStudy')?.value,
        hasLanguageCertificate: this.addStudentForm?.get('hasLanguageCertificate')?.value,
        gpa: this.addStudentForm?.get('gpa')?.value,
        hasReexaminations: this.addStudentForm?.get('hasReexaminations')?.value
      };

    this.userService.register(this.credentials).subscribe({
      next: (response: UserModel) => {
        const userId = response.id;
        console.log("USERUL ADUS: ");
        console.log(userId);
        newStudent.userId = userId!;
        this.studentService.insert(newStudent).subscribe({
          next: (studentResponse) => {
            console.log('Student inserted:', studentResponse);
          },
          error: (insertError) => {
            console.error('There was an error inserting the student:', insertError);
          }
        });
      },
      error: (err) => {
        console.error('There was an error registering the user:', err);
      }
    });

    this.router.navigateByUrl('auth/register/all-done');
  }

  onRepresentativeSubmit(): void {
      const newRepresentative = {
          userId: '',
          name: this.addRepresentativeForm?.get('name')?.value,
          cnp: this.addRepresentativeForm?.get('cnp')?.value,
          phoneNumber: this.addRepresentativeForm?.get('phoneNumber')?.value,
          dateOfBirth: this.addRepresentativeForm?.get('dateOfBirth')?.value,
          universityCode: this.addRepresentativeForm?.get('universityCode')?.value,
          facultyCode: this.addRepresentativeForm?.get('facultyCode')?.value,
          country: this.addRepresentativeForm?.get('country')?.value,
          city: this.addRepresentativeForm?.get('city')?.value,
          titles: this.addRepresentativeForm?.get('titles')?.value,
          type: this.representativeType
        };

      this.userService.register(this.credentials).subscribe({
        next: (response: UserModel) => {
          const userId = response.id;
          console.log("USERUL ADUS: ");
          console.log(userId);
          newRepresentative.userId = userId!;
          this.representativeService.insert(newRepresentative).subscribe({
            next: (representativeResponse) => {
              console.log('Representative inserted:', representativeResponse);
            },
            error: (insertError) => {
              console.error('There was an error inserting the representative:', insertError);
            }
          });
        },
        error: (err) => {
          console.error('There was an error registering the user:', err);
        }
      });

      this.router.navigateByUrl('auth/register/all-done');
    }

}
