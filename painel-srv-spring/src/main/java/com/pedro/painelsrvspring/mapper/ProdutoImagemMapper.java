package com.pedro.painelsrvspring.mapper;

import com.pedro.painelsrvspring.dto.ProdutoImagemDTO;
import com.pedro.painelsrvspring.model.ProdutoImagem;

public class ProdutoImagemMapper {

    public static ProdutoImagemDTO toDTO(ProdutoImagem produtoImagem) {
        if (produtoImagem == null) {
            return null;
        }
        return new ProdutoImagemDTO(
                produtoImagem.getId(),
                produtoImagem.getPrincipal(),
                produtoImagem.getUriImagem()
        );
    }

    public static ProdutoImagem toEntity(ProdutoImagemDTO produtoImagemDTO) {
        if (produtoImagemDTO == null) {
            return null;
        }
        ProdutoImagem produtoImagem = new ProdutoImagem();
        produtoImagem.setId(produtoImagemDTO.id());
        produtoImagem.setPrincipal(produtoImagemDTO.principal());
        produtoImagem.setUriImagem(produtoImagemDTO.uriImagem());
        return produtoImagem;
    }
}
