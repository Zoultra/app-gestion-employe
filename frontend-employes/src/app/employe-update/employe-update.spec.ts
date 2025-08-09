import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeUpdate } from './employe-update';

describe('EmployeUpdate', () => {
  let component: EmployeUpdate;
  let fixture: ComponentFixture<EmployeUpdate>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EmployeUpdate]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EmployeUpdate);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
