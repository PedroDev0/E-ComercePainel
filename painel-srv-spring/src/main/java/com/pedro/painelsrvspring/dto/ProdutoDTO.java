package com.pedro.painelsrvspring.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import com.pedro.painelsrvspring.model.Produto;

public record ProdutoDTO(Integer id, String descricao, BigDecimal precoCompra, BigDecimal precoVenda, Date dataCadastro,
		Set<ProdutoImagemDTO> imagens) {

	public static ProdutoDTO fromEntity(Produto produto) {
		return new ProdutoDTO(produto.getId(),
				produto.getDescricao(), 
				produto.getPrecoCompra(),
				produto.getPrecoVenda(), 
				produto.getDataCadastro(),
				null);
	}
}
