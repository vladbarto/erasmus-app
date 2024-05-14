import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UniqueSubjectComponent } from './unique-subject.component';

describe('UniqueSubjectComponent', () => {
  let component: UniqueSubjectComponent;
  let fixture: ComponentFixture<UniqueSubjectComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [UniqueSubjectComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(UniqueSubjectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
