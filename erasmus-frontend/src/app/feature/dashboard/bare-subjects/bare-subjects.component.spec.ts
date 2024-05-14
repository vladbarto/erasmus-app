import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BareSubjectsComponent } from './bare-subjects.component';

describe('BareSubjectsComponent', () => {
  let component: BareSubjectsComponent;
  let fixture: ComponentFixture<BareSubjectsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [BareSubjectsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(BareSubjectsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
