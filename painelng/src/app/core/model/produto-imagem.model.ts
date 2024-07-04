import { ProdutoImagemId } from "./produto-imagem-id.model";

export class ProdutoImagem{
     id: ProdutoImagemId = new ProdutoImagemId;
     principal: boolean= null;
     uriImagem: string= null;
}