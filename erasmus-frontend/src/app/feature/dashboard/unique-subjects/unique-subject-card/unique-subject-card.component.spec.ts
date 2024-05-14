import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UniqueSubjectCardComponent } from './unique-subject-card.component';

describe('UniqueSubjectCardComponent', () => {
  let component: UniqueSubjectCardComponent;
  let fixture: ComponentFixture<UniqueSubjectCardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [UniqueSubjectCardComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(UniqueSubjectCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
