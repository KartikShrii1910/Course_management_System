import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListofpurchsecourseComponent } from './listofpurchsecourse.component';

describe('ListofpurchsecourseComponent', () => {
  let component: ListofpurchsecourseComponent;
  let fixture: ComponentFixture<ListofpurchsecourseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ListofpurchsecourseComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ListofpurchsecourseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
