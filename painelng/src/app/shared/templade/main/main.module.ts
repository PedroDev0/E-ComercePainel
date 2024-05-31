import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MainComponent } from './main.component';
import { SharedModule } from '../../shared.module';
import { AppRoutingModule } from 'src/app/app-routing.module';



@NgModule({
  exports: [MainComponent],
  declarations: [
    MainComponent
  ],
  imports: [
    CommonModule,
    SharedModule,
    AppRoutingModule
  ]
})
export class MainModule { }
