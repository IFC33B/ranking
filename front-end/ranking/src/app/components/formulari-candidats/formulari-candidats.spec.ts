import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormulariCandidats } from './formulari-candidats';

describe('FormulariCandidats', () => {
  let component: FormulariCandidats;
  let fixture: ComponentFixture<FormulariCandidats>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormulariCandidats]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormulariCandidats);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
