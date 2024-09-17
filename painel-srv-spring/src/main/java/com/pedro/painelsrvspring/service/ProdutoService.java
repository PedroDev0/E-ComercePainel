package com.pedro.painelsrvspring.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.painelsrvspring.dto.ProdutoDetailsDTO;
import com.pedro.painelsrvspring.dto.ProdutoUpdateDTO;
import com.pedro.painelsrvspring.model.Produto;
import com.pedro.painelsrvspring.repository.ProdutoRepository;

import jakarta.transaction.Transactional;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public List<ProdutoDetailsDTO> getAllProducts(Integer id, String descricao, Date dataDe, Date dataAte,
			BigDecimal precoVenda, BigDecimal precoCompra) {

		List<Produto> produtos = produtoRepository.findAllByCond(id, descricao, dataDe, dataAte, precoVenda,
				precoCompra);
		return produtos.stream().map(ProdutoDetailsDTO::new).collect(Collectors.toList());
	}

	public ProdutoDetailsDTO findById(Integer id) {

		return new ProdutoDetailsDTO(produtoRepository.getReferenceById(id));
	}

	@Transactional
	public Produto update(ProdutoUpdateDTO dto) {
		
		Produto produto = produtoRepository.getReferenceById(dto.id());
		produto.update(dto);
		return produto;
	}

	@Transactional
	public Produto create(ProdutoUpdateDTO dto) {
		
		Produto produto;
		if (Objects.isNull(dto.id())) {
			produto = new Produto();
			produto.create(dto);
			produto = produtoRepository.save(produto);
			return produto;
		}

		produto = produtoRepository.getReferenceById(dto.id());
		produto.update(dto);
		return produto;
	}


	@Transactional
	public void deleteProductById(Integer id) {
		
		produtoRepository.deleteById(id);
	}

}
