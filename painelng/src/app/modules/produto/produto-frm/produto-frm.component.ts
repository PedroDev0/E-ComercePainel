import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Validators } from '@angular/forms';
import { DynamicDialogConfig, DynamicDialogRef } from 'primeng/dynamicdialog';
import { FormGroupModel } from 'src/app/core/model/form-group.model';
import { ProdutoImagemId } from 'src/app/core/model/produto-imagem-id.model';
import Produto from 'src/app/core/model/produto.model';
import { UtilService } from 'src/app/shared/services/util.service';
import { ProdutoService } from '../produto.service';
import { ProdutoImagem } from './../../../core/model/produto-imagem.model';

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
    private util: UtilService) {

  }
  ngOnInit(): void {
    this.novo = this.config?.data?.novo;

    if (this.config?.data?.produto) {
      this.form.patchValue(this.config?.data?.produto)
      this.imagens = this.config?.data?.produto.imagens

      this.imagens.forEach(e => {
        if (e?.principal) {
          this.principalImagem = e;
        }
      });
    }
  }

  protected novo: boolean = false;
  protected principalImagem: ProdutoImagem;
  protected imagens: ProdutoImagem[] = [];

  form = new FormGroupModel<Produto>(new Produto(), new Map<string, any>([
    ["descricao", [Validators.required, Validators.maxLength(250), Validators.minLength(5)]],
    ["precoCompra", [Validators.required, Validators.min(0.01)]],
    ["precoVenda", [Validators.required, Validators.min(0.01)]],
    ["uriImage", [Validators.required, Validators.min(0.01)]]
  ]));


  cancelar() {
    this.close();
  }

  salvar() {

    if (this.validaTela()) {
      this.montaEntity();

      if (this.novo) {
       
        this.form.controls.dataCadastro.patchValue(new Date());
        this.service.create(this.form.getRawValue()).subscribe(entity => {
          this.form.patchValue(entity);
          this.imagens = entity.imagens;
          this.util.showInfo("Produto criado!");
        });
        return;
      }

      this.service.update(this.form.getRawValue()).subscribe(entity => {
        this.form.patchValue(entity);
        this.imagens = entity.imagens;
        this.util.showInfo("Produto atualizado!");
      });
    }
  }
  montaEntity() {
    this.form.controls.imagens.patchValue(this.imagens);
  }

  validaTela(): boolean {

    if (this.form.invalid) {
      this.util.showWarn("Falta preencher alguns campos!");
      this.util.showWarn("Favor verificar o formulário!");
      return false;
    }
    if (this.imagens?.length <= 0) {
      this.util.showWarn("Adicione pelo menos uma imagem!");
      return false;
    }
    return true;
  }

  apagar() {
    this.util.showConfirmDialog(
      "Deseja realmente apagar este produto?",
      "Deletar Produto"
    ).then(confirmed => {
      if (confirmed) {

        this.service.delete(this.form.controls.id.getRawValue()).subscribe(deletado => {
          if (deletado) {
            this.util.showInfo("Produto deletado com sucesso!")
            this.close(deletado);
          }
        }
        );
      }
    });


  }


  close(deletato?: boolean) {
    this.ref.close(deletato);
  }

  removeImage(imagemARemover: ProdutoImagem) {
    this.imagens = this.imagens.filter(imagem => imagemARemover !== imagem);
  }
  addImage(input: any) {

    if (!input.value) {
      this.util.showWarn("Digite uma url válida!");
      return;
    }
    //Cria Imagem
    this.imagens.push(this.createImagem(input.value));
    input.value = "";
    this.dectorRef.detectChanges();
  }

  createImagem(uri: string): ProdutoImagem {

    let imagem: ProdutoImagem = new ProdutoImagem();
    imagem.uriImagem = uri;

    return imagem;
  }
  onPrincipalChange(event: any, imagem: ProdutoImagem) {

    //imagem da vez
    imagem.principal = event.checked;

    if (event.checked) {
      this.principalImagem = imagem;

      this.imagens.forEach(img => {
        if (img !== imagem) {
          img.principal = false;
        }
      });
    }
  }
}