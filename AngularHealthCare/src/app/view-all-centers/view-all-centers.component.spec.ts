import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewAllCentersComponent } from './view-all-centers.component';

describe('ViewAllCentersComponent', () => {
  let component: ViewAllCentersComponent;
  let fixture: ComponentFixture<ViewAllCentersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewAllCentersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewAllCentersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
