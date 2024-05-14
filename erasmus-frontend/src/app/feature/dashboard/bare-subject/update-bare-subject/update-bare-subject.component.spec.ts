import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateBareSubjectComponent } from './update-bare-subject.component';

describe('UpdateBareSubjectComponent', () => {
  let component: UpdateBareSubjectComponent;
  let fixture: ComponentFixture<UpdateBareSubjectComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [UpdateBareSubjectComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(UpdateBareSubjectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
