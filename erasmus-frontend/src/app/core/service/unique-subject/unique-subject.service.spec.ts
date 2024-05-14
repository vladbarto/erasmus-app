import { TestBed } from '@angular/core/testing';

import { UniqueSubjectService } from './unique-subject.service';

describe('UniqueSubjectService', () => {
  let service: UniqueSubjectService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UniqueSubjectService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
