import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CoordenadoresPanelComponent } from './coordenadores-panel.component';

describe('CoordenadoresPanelComponent', () => {
  let component: CoordenadoresPanelComponent;
  let fixture: ComponentFixture<CoordenadoresPanelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CoordenadoresPanelComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CoordenadoresPanelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
