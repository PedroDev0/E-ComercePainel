package com.pedro.painelsrvspring.dto;

import com.pedro.painelsrvspring.model.ProdutoImagem;

public record ProdutoImagemDetailsDTO(Integer id, Boolean principal, String uriImagem) {

	public ProdutoImagemDetailsDTO(ProdutoImagem produtoImagem) {
        this(produtoImagem.getId(), 
             produtoImagem.getPrincipal(), 
             produtoImagem.getUriImagem());
    }
}
