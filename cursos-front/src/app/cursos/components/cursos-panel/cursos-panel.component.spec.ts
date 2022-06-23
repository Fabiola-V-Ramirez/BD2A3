import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CursosPanelComponent } from './cursos-panel.component';

describe('CursosPanelComponent', () => {
  let component: CursosPanelComponent;
  let fixture: ComponentFixture<CursosPanelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CursosPanelComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CursosPanelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
