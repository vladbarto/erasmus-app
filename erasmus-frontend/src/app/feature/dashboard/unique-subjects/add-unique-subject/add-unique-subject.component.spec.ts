import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddUniqueSubjectComponent } from './add-unique-subject.component';

describe('AddUniqueSubjectComponent', () => {
  let component: AddUniqueSubjectComponent;
  let fixture: ComponentFixture<AddUniqueSubjectComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AddUniqueSubjectComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AddUniqueSubjectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
