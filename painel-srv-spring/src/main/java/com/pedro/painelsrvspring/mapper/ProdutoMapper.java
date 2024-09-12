package com.pedro.painelsrvspring.mapper;


import java.util.stream.Collectors;

import com.pedro.painelsrvspring.dto.ProdutoDTO;
import com.pedro.painelsrvspring.model.Produto;

public class ProdutoMapper {


	    public static ProdutoDTO toDTO(Produto produto) {
	    	
	        if (produto == null) {
	            return null;
	        }
	        return new ProdutoDTO(
	                produto.getId(),
	                produto.getDescricao(),
	                produto.getPrecoCompra(),
	                produto.getPrecoVenda(),
	                produto.getDataCadastro(),
	                produto.getImagens().stream()
	                    .map(ProdutoImagemMapper::toDTO)
	                    .collect(Collectors.toList())
	        );
	    }

	    public static Produto toEntity(ProdutoDTO produtoDTO) {
	    	
	        if (produtoDTO == null) {
	            return null;
	        }
	        
	        Produto produto = new Produto();
	        produto.setId(produtoDTO.id());
	        produto.setDescricao(produtoDTO.descricao());
	        produto.setPrecoCompra(produtoDTO.precoCompra());
	        produto.setPrecoVenda(produtoDTO.precoVenda());
	        produto.setDataCadastro(produtoDTO.dataCadastro());
	        produto.setImagens(produtoDTO.imagens().stream()
	                    .map(ProdutoImagemMapper::toEntity)
	                    .collect(Collectors.toSet()));
	        return produto;
	    }
	}

