import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ToyNewComponent } from './toy-new.component';

describe('ToyNewComponent', () => {
  let component: ToyNewComponent;
  let fixture: ComponentFixture<ToyNewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ToyNewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ToyNewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
