import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateUniqueSubjectComponent } from './update-unique-subject.component';

describe('UpdateUniqueSubjectComponent', () => {
  let component: UpdateUniqueSubjectComponent;
  let fixture: ComponentFixture<UpdateUniqueSubjectComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [UpdateUniqueSubjectComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(UpdateUniqueSubjectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
