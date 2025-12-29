import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LlistaCandidats } from './llista-candidats';

describe('LlistaCandidats', () => {
  let component: LlistaCandidats;
  let fixture: ComponentFixture<LlistaCandidats>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LlistaCandidats]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LlistaCandidats);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
