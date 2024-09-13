package com.pedro.painelsrvspring.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pedro.painelsrvspring.dto.ProdutoDTO;
import com.pedro.painelsrvspring.service.ProdutoService;

@RestController
@RequestMapping("/products")
public class ProdutoController {

	@Autowired
	ProdutoService produtoService;

	@GetMapping("/all")
	private ResponseEntity<List<ProdutoDTO>> getAllProducts(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "descricao", required = false) String descricao,
			@RequestParam(value = "dataDe", required = false) Date dataDe,
			@RequestParam(value = "dataAte", required = false) Date dataAte,
			@RequestParam(value = "precoVenda", required = false) BigDecimal precoVenda,
			@RequestParam(value = "precoCompra", required = false) BigDecimal precoCompra) {
		return ResponseEntity
				.ok(produtoService.getAllProducts(id, descricao, dataDe, dataAte, precoVenda, precoCompra));
	}

	@GetMapping("/{id}")
	private ResponseEntity<ProdutoDTO> getById(@PathVariable Integer id) {

		return ResponseEntity.ok(produtoService.findById(id));
	}

	@PutMapping("/update")
	private ResponseEntity<ProdutoDTO> update(@RequestBody ProdutoDTO dto) {
		
		return produtoService.update(dto);

	}
}
