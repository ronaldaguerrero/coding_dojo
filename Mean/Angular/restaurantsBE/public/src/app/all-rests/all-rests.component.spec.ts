import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AllRestsComponent } from './all-rests.component';

describe('AllRestsComponent', () => {
  let component: AllRestsComponent;
  let fixture: ComponentFixture<AllRestsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AllRestsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AllRestsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
