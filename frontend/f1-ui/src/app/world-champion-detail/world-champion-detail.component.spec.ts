import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WorldChampionDetailComponent } from './world-champion-detail.component';

describe('WorldChampionDetailComponent', () => {
  let component: WorldChampionDetailComponent;
  let fixture: ComponentFixture<WorldChampionDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WorldChampionDetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WorldChampionDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
