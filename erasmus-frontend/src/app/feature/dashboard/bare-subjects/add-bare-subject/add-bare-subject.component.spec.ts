import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddBareSubjectComponent } from './add-bare-subject.component';

describe('AddBareSubjectComponent', () => {
  let component: AddBareSubjectComponent;
  let fixture: ComponentFixture<AddBareSubjectComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AddBareSubjectComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AddBareSubjectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
