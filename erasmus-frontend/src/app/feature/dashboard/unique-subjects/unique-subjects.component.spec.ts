import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UniqueSubjectsComponent } from './unique-subjects.component';

describe('UniqueSubjectsComponent', () => {
  let component: UniqueSubjectsComponent;
  let fixture: ComponentFixture<UniqueSubjectsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [UniqueSubjectsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(UniqueSubjectsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
