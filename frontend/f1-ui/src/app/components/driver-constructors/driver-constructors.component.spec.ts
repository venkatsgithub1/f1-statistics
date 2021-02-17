import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DriverConstructorsComponent } from './driver-constructors.component';

describe('DriverConstructorsComponent', () => {
  let component: DriverConstructorsComponent;
  let fixture: ComponentFixture<DriverConstructorsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DriverConstructorsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DriverConstructorsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
