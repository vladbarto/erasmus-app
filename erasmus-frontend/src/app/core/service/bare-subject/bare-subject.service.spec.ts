import { TestBed } from '@angular/core/testing';

import { BareSubjectService } from './bare-subject.service';

describe('BareSubjectService', () => {
  let service: BareSubjectService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BareSubjectService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
