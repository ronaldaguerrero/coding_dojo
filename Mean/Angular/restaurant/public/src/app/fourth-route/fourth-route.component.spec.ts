import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FourthRouteComponent } from './fourth-route.component';

describe('FourthRouteComponent', () => {
  let component: FourthRouteComponent;
  let fixture: ComponentFixture<FourthRouteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FourthRouteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FourthRouteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
