import { Component, OnInit } from '@angular/core';
import { Validators } from '@angular/forms';
import { DynamicDialogConfig, DynamicDialogRef } from 'primeng/dynamicdialog';
import { FormGroupModel } from 'src/app/model/form-group.model';
import Produto from 'src/app/model/produto.model';

@Component({
  selector: 'cmp-produto-frm',
  templateUrl: './produto-frm.component.html',
  styleUrls: ['./produto-frm.component.css']
})
export class ProdutoFrmComponent implements OnInit {


  enable: boolean = false;
  novo: boolean = false;

  form = new FormGroupModel<Produto>(new Produto(),new Map<string, any>([
    ["descricao", [Validators.maxLength(2)]],
    ["precoCompra", [Validators.min(0.1)]],
    ["precoVenda", [Validators.max(0.1)]]
  ] ));

  constructor(private ref: DynamicDialogRef, private config: DynamicDialogConfig) {

  }
  ngOnInit(): void {
    this.enable = this.config?.data?.enable;
    this.novo = this.config?.data?.novo;

    if (this.config?.data?.produto) {
      this.form.patchValue(this.config?.data?.produto)
    }
  }

  cancelar() {
    if (this.novo) {
      this.ref.close();
      return;
    }

    this.enable = false;
    // this.form.rel
  }

  salvar() {

    if (this.form.controls.descricao.invalid) {
      

    }
  }
  validaForms(): boolean {

    if (this.form.controls.descricao) {

    }
    if (this.form.controls.descricao) {

    }
    if (this.form.controls.descricao) {

    }
    if (this.form.controls.descricao) {

    }
      return true;
  }

  alterar() {
    this.enable = true;
  }

  close() {
    this.ref.close();
  }
}
