package com.pedro.painelsrvspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedro.painelsrvspring.dto.ProdutoDTO;
import com.pedro.painelsrvspring.service.ProdutoService;

@RestController
@RequestMapping("/product")
public class ProdutoController {

	@Autowired
	ProdutoService produtoService;
	
	@GetMapping
	@RequestMapping("/all-products")
	private ResponseEntity<List<ProdutoDTO>> getAllProducts() {
		return ResponseEntity.ok(produtoService.getAllProducts());
	}
}
