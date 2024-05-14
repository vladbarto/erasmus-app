import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BareSubjectComponent } from './bare-subject.component';

describe('BareSubjectComponent', () => {
  let component: BareSubjectComponent;
  let fixture: ComponentFixture<BareSubjectComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [BareSubjectComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(BareSubjectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
