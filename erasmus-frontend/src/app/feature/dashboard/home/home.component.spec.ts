import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeComponent } from './home.component';

describe('HomeComponent', () => {
  let component: HomeComponent;
  let fixture: ComponentFixture<HomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [HomeComponent]
    })
      .compileComponents();

    fixture = TestBed.createComponent(HomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    // when
    fixture.detectChanges()

    // then
    expect(component).toBeTruthy();
  });

  it('should expand mail sending interface', () => {
    // given
    fixture.detectChanges();
    const button: HTMLButtonElement = fixture.debugElement.nativeElement.querySelector('#mail-button');
    const buttonSpy = spyOn(component as any, 'showMailMethod').and.callThrough();

    // when
    button.click();

    // then
    expect(buttonSpy).toHaveBeenCalled();
  });

});
