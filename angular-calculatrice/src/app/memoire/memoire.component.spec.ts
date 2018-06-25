import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MemoireComponent } from './memoire.component';

describe('MemoireComponent', () => {
  let component: MemoireComponent;
  let fixture: ComponentFixture<MemoireComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MemoireComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MemoireComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
