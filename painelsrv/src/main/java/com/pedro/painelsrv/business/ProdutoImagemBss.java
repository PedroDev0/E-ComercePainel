package com.pedro.painelsrv.business;

import java.util.List;

import javax.ejb.Stateless;

import com.pedro.painelsrv.domain.ProdutoImagem;

@Stateless
public class ProdutoImagemBss extends Bss<ProdutoImagem> {

	private static final long serialVersionUID = 1L;

	List<ProdutoImagem> getListByProd(Integer idProduto) {
		return dao.getListByCond(" id.produtoId = " + idProduto);
	}

}
