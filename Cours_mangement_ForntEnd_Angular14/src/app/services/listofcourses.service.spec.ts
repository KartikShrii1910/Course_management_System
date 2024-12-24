import { TestBed } from '@angular/core/testing';

import { ListofcoursesService } from './listofcourses.service';

describe('ListofcoursesService', () => {
  let service: ListofcoursesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ListofcoursesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
