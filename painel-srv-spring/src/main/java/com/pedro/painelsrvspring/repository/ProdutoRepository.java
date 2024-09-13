package com.pedro.painelsrvspring.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pedro.painelsrvspring.model.Produto;

@Repository
public interface  ProdutoRepository extends JpaRepository<Produto, Integer> {
	
	@Query("SELECT p FROM PRODUTO p WHERE "
		       + "(?1 IS NULL OR p.id = ?1) "
		       + "AND (?2 IS NULL OR p.descricao LIKE ?2%) "
		       + "AND (?3 IS NULL OR p.dataCadastro >= ?3) "
		       + "AND (?4 IS NULL OR p.dataCadastro <= ?4) "
		       + "AND (?5 IS NULL OR p.precoVenda >= ?5) "
		       + "AND (?6 IS NULL OR p.precoCompra <= ?6)")
	public List<Produto> findAllByCond(Integer id, String descricao, Date dataDe, Date dataAte, BigDecimal precoVenda, BigDecimal precoCompra);
}
