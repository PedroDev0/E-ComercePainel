package com.pedro.painelsrvspring.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedro.painelsrvspring.dto.ProdutoDTO;

@RestController
@RequestMapping("/product")
public class ProdutoController {

	@GetMapping
	@RequestMapping("/all-products")
	private ResponseEntity<List<ProdutoDTO>> getAllProducts(){
		
		List<ProdutoDTO> dtos = new ArrayList<ProdutoDTO>();
		
		dtos.add(new ProdutoDTO(1, "Bicicleta",new BigDecimal("20.00"), new BigDecimal("20.00"), new Date(), null));
		dtos.add(new ProdutoDTO(1, "tablet",new BigDecimal("20.00"), new BigDecimal("20.00"), new Date(), null));
		dtos.add(new ProdutoDTO(1, "carroça",new BigDecimal("20.00"), new BigDecimal("20.00"), new Date(), null));
		dtos.add(new ProdutoDTO(1, "carro",new BigDecimal("20.00"), new BigDecimal("20.00"), new Date(), null));
		
		return ResponseEntity.ok(dtos);
	}
}
