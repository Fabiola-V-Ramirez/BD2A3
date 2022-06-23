import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AlunosPanelComponent } from './alunos-panel.component';

describe('AlunosPanelComponent', () => {
  let component: AlunosPanelComponent;
  let fixture: ComponentFixture<AlunosPanelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AlunosPanelComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AlunosPanelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
