import { ProdutoImagem } from "./produto-imagem.model";
import Produto from "./produto.model";

export class ProdutoUpdate {
    public id: number;
    public descricao:string
    public precoCompra: number;
    public precoVenda: number;
    public imagens: ProdutoImagem[];

    constructor(produto: Produto) {
        this.id = produto.id;
        this.precoCompra = produto.precoCompra;
        this.precoVenda = produto.precoVenda;
        this.imagens = produto.imagens;
        this.descricao = produto.descricao;
    }
}
