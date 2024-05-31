import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DisableListenerDirective } from './disable-listener.directive';



@NgModule({
  exports:[DisableListenerDirective],
  declarations: [DisableListenerDirective],
  imports: [
    CommonModule,
  ]
})
export class DisableListenerModule { }
