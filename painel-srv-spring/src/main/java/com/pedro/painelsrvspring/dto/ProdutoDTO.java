package com.pedro.painelsrvspring.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.pedro.painelsrvspring.model.Produto;

public record ProdutoDTO(Integer id, String descricao, BigDecimal precoCompra, BigDecimal precoVenda, Date dataCadastro,
		  @JsonDeserialize(contentAs = ProdutoImagemDTO.class) List<ProdutoImagemDTO> imagens) {

	public ProdutoDTO(Produto produto) {
		this(produto.getId(), 
				produto.getDescricao(), 
				produto.getPrecoCompra(),
				produto.getPrecoVenda(),
				produto.getDataCadastro(), 
				produto.getImagens().stream().map(ProdutoImagemDTO::new).toList());
	}
}
