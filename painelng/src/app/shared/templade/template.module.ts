import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TemplateComponent } from './template.component';

import { NavModule } from './nav/nav.module';
import { AppRoutingModule } from 'src/app/app-routing.module';
import { MainModule } from './main/main.module';




@NgModule({
  exports: [TemplateComponent],
  declarations: [
    TemplateComponent
  ],
  imports: [
    CommonModule,
    NavModule,
    MainModule,
    AppRoutingModule
    
  ]
})
export class TempladeModule { }
