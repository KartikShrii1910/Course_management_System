import { TestBed } from '@angular/core/testing';

import { ListofstudentsService } from './listofstudents.service';

describe('ListofstudentsService', () => {
  let service: ListofstudentsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ListofstudentsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
