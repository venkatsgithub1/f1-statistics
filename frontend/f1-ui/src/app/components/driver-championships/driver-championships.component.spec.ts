import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DriverChampionshipsComponent } from './driver-championships.component';

describe('DriverChampionshipsComponent', () => {
  let component: DriverChampionshipsComponent;
  let fixture: ComponentFixture<DriverChampionshipsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DriverChampionshipsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DriverChampionshipsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
