import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ModulesRoutingModule } from './modules-routing.module';
import { ProdutoModule } from './produto/produto.module';
import { HomeModule } from './home/home.module';

@NgModule({
  declarations: [
  ],
  imports: [
    CommonModule,
    ModulesRoutingModule,
    ProdutoModule,
    HomeModule
  ],

})
export class ModulesModule { }
