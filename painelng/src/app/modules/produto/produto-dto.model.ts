import Produto from 'src/app/core/model/produto.model';
import { ProdutoImagem } from './../../core/model/produto-imagem.model';

export class ProdutoDTO {
    produto: Produto = new Produto();
    imagens: ProdutoImagem[] =[];
}