package com.pedro.painelsrv.endpoint.dto;

import java.util.List;

import com.pedro.painelsrv.domain.Produto;
import com.pedro.painelsrv.domain.ProdutoImagem;

public class ProdutoDto {
	
	private Produto produto;
	private List<ProdutoImagem> imagens;
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public List<ProdutoImagem> getImagens() {
		return imagens;
	}
	public void setImagens(List<ProdutoImagem> imagens) {
		this.imagens = imagens;
	}
	
}
