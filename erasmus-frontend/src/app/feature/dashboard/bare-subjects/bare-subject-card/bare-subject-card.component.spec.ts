import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BareSubjectCardComponent } from './bare-subject-card.component';

describe('BareSubjectCardComponent', () => {
  let component: BareSubjectCardComponent;
  let fixture: ComponentFixture<BareSubjectCardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [BareSubjectCardComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(BareSubjectCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
