import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { DynamicDialogRef } from 'primeng/dynamicdialog';
import { UtilService } from 'src/app/shared/services/util.service';
import { ProdutoFrmComponent } from './produto-frm/produto-frm.component';
import { ProdutoService } from './produto.service';
import Produto from 'src/app/core/model/produto.model';
import { FormGroupModel } from 'src/app/core/model/form-group.model';
import { FiltrosProd } from './filttro.prod.model';

@Component({
  selector: 'cmp-produto',
  templateUrl: './produto.component.html',
  styleUrls: ['./produto.component.css']
})

export class ProdutoComponent {


  products: Produto[] = [];
  form = new FormGroupModel<FiltrosProd>(new FiltrosProd());
  selectedProduct: any;
  sidebarVisible2: boolean = false;

  constructor(private service: ProdutoService, private utilService: UtilService) {

  }
  getList() {
    this.service.getListProduto(this.form.getRawValue()).subscribe(list => {
      this.products = list;
    })
  }
  showFrm() {
    let ref: DynamicDialogRef = this.utilService.showDialog(ProdutoFrmComponent, {
      header: 'Produto',
      width: '44vw',
      height: '44vh',
      closable: false,
      data: {
        novo: true,
        enable: true
      }
    });
  }

  doubleClickRow(produto: Produto) {
    let ref: DynamicDialogRef = this.utilService.showDialog(ProdutoFrmComponent, {
      header: 'Produto',
      width: '44vw',
      height: '44vh',
      closable: false,
      data: {
        novo: false,
        enable: true,
        produto: produto
      }
    });
  }


}
