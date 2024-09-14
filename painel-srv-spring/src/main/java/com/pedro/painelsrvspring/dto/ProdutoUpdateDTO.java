package com.pedro.painelsrvspring.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.pedro.painelsrvspring.model.Produto;

public record ProdutoUpdateDTO(Integer id, String descricao, BigDecimal precoCompra, BigDecimal precoVenda,
		@JsonDeserialize(contentAs = ProdutoImagemDetailsDTO.class) List<ProdutoImagemDetailsDTO> imagens) {

	public ProdutoUpdateDTO(Produto produto) {
		this(produto.getId(), produto.getDescricao(), produto.getPrecoCompra(), produto.getPrecoVenda(),
				produto.getImagens().stream().map(ProdutoImagemDetailsDTO::new).toList());
	}

}
