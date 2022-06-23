import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfessoresDetailsComponent } from './professores-details.component';

describe('ProfessoresDetailsComponent', () => {
  let component: ProfessoresDetailsComponent;
  let fixture: ComponentFixture<ProfessoresDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProfessoresDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfessoresDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
