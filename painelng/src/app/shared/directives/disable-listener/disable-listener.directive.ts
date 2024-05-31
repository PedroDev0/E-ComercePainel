import { Directive,  Input, OnChanges, SimpleChanges } from '@angular/core';
import { NgControl } from '@angular/forms';

@Directive({
  selector: '[cmpDisableListener]'
})
export class DisableListenerDirective implements OnChanges {

  constructor(private ngControl: NgControl) { }

  @Input('disableValue') disableValue: boolean;

  ngOnChanges(changes: SimpleChanges): void {

    if ('disableValue' in changes) {
      this.updateDisabledState();
    }
  }


  updateDisabledState() {
    if (this.disableValue) {
      this.ngControl.control['disable']();
      return;
    }

    this.ngControl.control['enable']();
  }
}
