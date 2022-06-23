import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DisciplinasPanelComponent } from './disciplinas-panel.component';

describe('DisciplinasPanelComponent', () => {
  let component: DisciplinasPanelComponent;
  let fixture: ComponentFixture<DisciplinasPanelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DisciplinasPanelComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DisciplinasPanelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
