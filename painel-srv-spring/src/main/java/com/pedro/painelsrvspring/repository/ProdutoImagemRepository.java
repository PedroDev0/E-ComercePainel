package com.pedro.painelsrvspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedro.painelsrvspring.model.ProdutoImagem;

public interface ProdutoImagemRepository  extends JpaRepository<ProdutoImagem, Integer> {

}
