package com.pedro.painelsrvspring.service;

import java.math.BigDecimal;
import java.util.Date;
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

	public List<ProdutoDTO> getAllProducts(Integer id, String descricao, Date dataDe, Date dataAte,
			BigDecimal precoVenda, BigDecimal precoCompra) {

		List<Produto> produtos = produtoRepository.findAllByCond(id, descricao, dataDe, dataAte, precoVenda,
				precoCompra);
		return produtos.stream().map(ProdutoMapper::toDTO).collect(Collectors.toList());
	}

	public ProdutoDTO getById(Integer id) {
		
		return ProdutoMapper.toDTO(produtoRepository.findById(id).get());
	}

}
