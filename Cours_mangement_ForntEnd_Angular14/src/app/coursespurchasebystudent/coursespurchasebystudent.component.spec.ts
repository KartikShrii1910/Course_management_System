import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CoursespurchasebystudentComponent } from './coursespurchasebystudent.component';

describe('CoursespurchasebystudentComponent', () => {
  let component: CoursespurchasebystudentComponent;
  let fixture: ComponentFixture<CoursespurchasebystudentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CoursespurchasebystudentComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CoursespurchasebystudentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
