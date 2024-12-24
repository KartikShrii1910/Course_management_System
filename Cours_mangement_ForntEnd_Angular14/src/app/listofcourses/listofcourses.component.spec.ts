import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListofcoursesComponent } from './listofcourses.component';

describe('ListofcoursesComponent', () => {
  let component: ListofcoursesComponent;
  let fixture: ComponentFixture<ListofcoursesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ListofcoursesComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ListofcoursesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
