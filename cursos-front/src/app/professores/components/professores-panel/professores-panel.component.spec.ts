import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfessoresPanelComponent } from './professores-panel.component';

describe('ProfessoresPanelComponent', () => {
  let component: ProfessoresPanelComponent;
  let fixture: ComponentFixture<ProfessoresPanelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProfessoresPanelComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfessoresPanelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
