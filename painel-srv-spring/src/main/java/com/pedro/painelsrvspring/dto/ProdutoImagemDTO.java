package com.pedro.painelsrvspring.dto;

import com.pedro.painelsrvspring.model.ProdutoImagem;

public record ProdutoImagemDTO(Integer id, Boolean principal, String uriImagem) {

	public ProdutoImagemDTO(ProdutoImagem produtoImagem) {
        this(produtoImagem.getId(), 
             produtoImagem.getPrincipal(), 
             produtoImagem.getUriImagem());
    }
}
