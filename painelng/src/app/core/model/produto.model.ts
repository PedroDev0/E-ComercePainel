import { ProdutoImagem } from "./produto-imagem.model";

export default class Produto {
    id: number = null;
    descricao: string = null;
    precoCompra: number = null;
    precoVenda: number = null;
    dataCadastro:Date= null;
    imagens:ProdutoImagem[]=null;
}