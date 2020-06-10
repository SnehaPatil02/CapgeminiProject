import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewAllTestsComponent } from './view-all-tests.component';

describe('ViewAllTestsComponent', () => {
  let component: ViewAllTestsComponent;
  let fixture: ComponentFixture<ViewAllTestsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewAllTestsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewAllTestsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
