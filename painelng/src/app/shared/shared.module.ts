import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { InputNumberModule } from 'primeng/inputnumber';

import { ButtonModule } from 'primeng/button';
import { CardModule } from 'primeng/card';
import { TableModule } from 'primeng/table';
import { TagModule } from 'primeng/tag';
import { RatingModule } from 'primeng/rating';
import { InputTextModule } from 'primeng/inputtext';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { DisableListenerDirective } from './directives/disable-listener/disable-listener.directive';
import { DisableListenerModule } from './directives/disable-listener/disable-listener.module';



@NgModule({

  declarations: [
  
  ],
  exports:[
    InputNumberModule,
    ButtonModule,
    CardModule,
    TableModule,
    TagModule,
    RatingModule,
    InputTextModule,
    FormsModule,
    ReactiveFormsModule,
    DisableListenerModule
    
  ],
  imports: [
    CommonModule,
    InputNumberModule,
    ButtonModule,
    CardModule,
    TableModule,
    TagModule,
    RatingModule,
    InputTextModule,
    FormsModule,
    ReactiveFormsModule,
    DisableListenerModule
    
  ]
})
export class SharedModule { }
