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
import { DisableListenerModule } from './directives/disable-listener/disable-listener.module';
import { TabViewModule } from 'primeng/tabview';
import { ImageModule } from 'primeng/image';
import { SidebarModule } from 'primeng/sidebar';
import { CalendarModule } from 'primeng/calendar';



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
    DisableListenerModule,
    TabViewModule,
    ImageModule,
    SidebarModule,
    CalendarModule
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
    DisableListenerModule,
    TabViewModule,
    ImageModule,
    SidebarModule,
    CalendarModule
    
  ]
})
export class SharedModule { }
