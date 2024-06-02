import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ErasmusJourneyComponent } from './erasmus-journey.component';

describe('ErasmusJourneyComponent', () => {
  let component: ErasmusJourneyComponent;
  let fixture: ComponentFixture<ErasmusJourneyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ErasmusJourneyComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ErasmusJourneyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
