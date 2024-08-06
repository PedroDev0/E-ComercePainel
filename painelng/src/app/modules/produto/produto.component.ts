import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { DynamicDialogRef } from 'primeng/dynamicdialog';
import { UtilService } from 'src/app/shared/services/util.service';
import { ProdutoFrmComponent } from './produto-frm/produto-frm.component';
import { ProdutoService } from './produto.service';
import Produto from 'src/app/core/model/produto.model';
import { FormGroupModel } from 'src/app/core/model/form-group.model';
import { FiltrosProd } from './filttro-prod.model';

@Component({
  selector: 'cmp-produto',
  templateUrl: './produto.component.html',
  styleUrls: ['./produto.component.css']
})

export class ProdutoComponent {


  protected products: Produto[] = [];
  protected form = new FormGroupModel<FiltrosProd>(new FiltrosProd());
  protected selectedProduct: any;
  protected sidebarVisible2: boolean = false;

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
      width: '55vw',
      height: '55vh',
      closable: false,
      data: {
        novo: true,
        enable: true
      }
    });
  }

  doubleClickRow(codProduto: number) {
  
  this.service.getProtudo(codProduto).subscribe(produto => {
      if (produto) {
        let ref: DynamicDialogRef = this.utilService.showDialog(ProdutoFrmComponent, {
          header: 'Produto',
          width: '55vw',
          height: '55vh',
          contentStyle: { "overflow": "hidden", "max-height": "calc(80vh - 50px)" },
          closable: false,
          data: {
            novo: false,
            enable: true,
            produto: produto
          }
        });

        ref.onClose.subscribe(deletado=>{

          if(deletado){
              this.getList();
          }
        });
      }
    }
    )
  }


}
