import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Validators } from '@angular/forms';
import { DynamicDialogConfig, DynamicDialogRef } from 'primeng/dynamicdialog';
import { FormGroupModel } from 'src/app/core/model/form-group.model';
import { ProdutoDTO } from '../produto-dto.model';
import { ProdutoService } from '../produto.service';
import { ProdutoImagem } from './../../../core/model/produto-imagem.model';
import { UtilService } from 'src/app/shared/services/util.service';

@Component({
  selector: 'cmp-produto-frm',
  templateUrl: './produto-frm.component.html',
  styleUrls: ['./produto-frm.component.css'],
  
})
export class ProdutoFrmComponent implements OnInit {


  constructor(private ref: DynamicDialogRef, 
    private config: DynamicDialogConfig, 
    private service: ProdutoService, 
    private dectorRef: ChangeDetectorRef,
    private util :UtilService) {

  }
  ngOnInit(): void {
    this.novo = this.config?.data?.novo;
    if (this.config?.data?.produto) {
      this.form.patchValue(this.config?.data?.produto)
    }
  }

  novo: boolean = false;

  form = new FormGroupModel<ProdutoDTO>(new ProdutoDTO(), new Map<string, any>([
    ["descricao", [Validators.required, Validators.maxLength(250), Validators.minLength(5)]],
    ["precoCompra", [Validators.required, Validators.min(0.01)]],
    ["precoVenda", [Validators.required, Validators.min(0.01)]],
    ["uriImage", [Validators.required, Validators.min(0.01)]]
  ]));

  imagens: ProdutoImagem[] = [];

  cancelar() {
    this.close();
    this.form.controls.produto.controls.id
  }

  salvar() {

    if (this.form.valid) {
      this.service.createOrUpdate(this.form.getRawValue()).subscribe(entity => {
        this.form.patchValue(entity);
      });
    }

  }

  apagar() {
    throw new Error('Method not implemented.');
  }


  close() {
    this.ref.close();
  }

  removeImage() {
    throw new Error('Method not implemented.');
  }
  addImage(uri: string, key:string) {

    if(!uri) {
      this.util.showMensagem("Digite uma url válida!", key);
      return;
    }
    let imagem: ProdutoImagem = new ProdutoImagem;
    imagem.id.produtoId = this.form.controls.produto.controls.id.getRawValue();
    imagem.uriImagem = uri;
    console.log("iamgem: " + uri)
    this.imagens.push(imagem);
    console.log(this.imagens);

    this.dectorRef.detectChanges();
  }
}
