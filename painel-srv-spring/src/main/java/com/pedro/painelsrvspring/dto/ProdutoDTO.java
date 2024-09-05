package com.pedro.painelsrvspring.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

public record ProdutoDTO(Integer id, String descricao, BigDecimal precoCompra, BigDecimal precoVenda,
		Date dataCadastro, Set<ProdutoImagemDTO> imagens) {

}
