package com.pedro.painelsrvspring.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.pedro.painelsrvspring.model.Produto;

public record ProdutoDetailsDTO(Integer id, String descricao, BigDecimal precoCompra, BigDecimal precoVenda,
		 LocalDateTime dataCadastro,
		@JsonDeserialize(contentAs = ProdutoImagemDetailsDTO.class) List<ProdutoImagemDetailsDTO> imagens) {

	public ProdutoDetailsDTO(Produto produto) {
		this(produto.getId(), produto.getDescricao(), produto.getPrecoCompra(), produto.getPrecoVenda(),
				produto.getDataCadastro(), produto.getImagens().stream().map(ProdutoImagemDetailsDTO::new).toList());
	}
}
