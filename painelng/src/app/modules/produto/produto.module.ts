import { NgModule } from '@angular/core';

import { ProdutoRoutingModule } from './produto-routing.module';
import { ProdutoComponent } from './produto.component';

import { SharedModule as MyShared } from 'src/app/shared/shared.module';
import { ProdutoFrmComponent } from './produto-frm/produto-frm.component';


@NgModule({
  exports: [ProdutoComponent],
  declarations: [
    ProdutoComponent,
    ProdutoFrmComponent
  ],
  imports: [
    ProdutoRoutingModule,
    MyShared
  ]
})
export class ProdutoModule { }
