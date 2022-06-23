import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DisciplinasDetailsComponent } from './disciplinas-details.component';

describe('DisciplinasDetailsComponent', () => {
  let component: DisciplinasDetailsComponent;
  let fixture: ComponentFixture<DisciplinasDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DisciplinasDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DisciplinasDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
