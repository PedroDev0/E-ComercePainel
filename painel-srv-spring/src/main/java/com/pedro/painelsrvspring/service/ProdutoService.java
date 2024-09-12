package com.pedro.painelsrvspring.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.painelsrvspring.dto.ProdutoDTO;
import com.pedro.painelsrvspring.mapper.ProdutoMapper;
import com.pedro.painelsrvspring.model.Produto;
import com.pedro.painelsrvspring.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public List<ProdutoDTO> getAllProducts() {
		
		 List<Produto> produtos = produtoRepository.findAll();
	        return produtos.stream()
	                .map(ProdutoMapper::toDTO)
	                .collect(Collectors.toList());
	}


}
