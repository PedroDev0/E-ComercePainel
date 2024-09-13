package com.pedro.painelsrvspring.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pedro.painelsrvspring.dto.ProdutoDTO;
import com.pedro.painelsrvspring.mapper.ProdutoMapper;
import com.pedro.painelsrvspring.model.Produto;
import com.pedro.painelsrvspring.repository.ProdutoImagemRepository;
import com.pedro.painelsrvspring.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ProdutoImagemRepository prodImagemRepository;

	public List<ProdutoDTO> getAllProducts(Integer id, String descricao, Date dataDe, Date dataAte,
			BigDecimal precoVenda, BigDecimal precoCompra) {

		List<Produto> produtos = produtoRepository.findAllByCond(id, descricao, dataDe, dataAte, precoVenda,
				precoCompra);
		return produtos.stream().map(ProdutoMapper::toDTO).collect(Collectors.toList());
	}

	public ProdutoDTO findById(Integer id) {

		return ProdutoMapper.toDTO(produtoRepository.findById(id).get());
	}

	public ResponseEntity<ProdutoDTO> update(ProdutoDTO dto) {

		Optional<Produto> produtoExist = produtoRepository.findById(dto.id());
		Produto produtoUpdate = ProdutoMapper.toEntity(dto);

		if (produtoExist.isPresent()) {
			produtoRepository.save(produtoUpdate);
			prodImagemRepository.saveAll(produtoUpdate.getImagens());

			return new ResponseEntity<>(new ProdutoDTO(produtoUpdate), HttpStatus.OK);
		}

		return ResponseEntity.notFound().build();
	}

}
