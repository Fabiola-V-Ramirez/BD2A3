import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CursosDetailsComponent } from './cursos-details.component';

describe('CursosDetailsComponent', () => {
  let component: CursosDetailsComponent;
  let fixture: ComponentFixture<CursosDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CursosDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CursosDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
