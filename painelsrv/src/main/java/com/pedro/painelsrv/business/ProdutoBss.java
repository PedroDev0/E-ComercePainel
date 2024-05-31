package com.pedro.painelsrv.business;

import java.util.List;

import javax.ejb.Stateless;

import com.pedro.painelsrv.domain.Produto;

@Stateless
public class ProdutoBss extends Bss<Produto> {

	private static final long serialVersionUID = 1L;

	public List<Produto> getList() {

		return dao.getList();
	}

	public Produto create(Produto entity) {

		entity.setId(dao.getNextPk("id"));
		return dao.persit(entity);
	}

	public List<Produto> getListByCond(String id, String descricao, String precoCompra, String precoVenda) {

		StringBuilder condicao = new StringBuilder();
		
		condicao.append(" o.id is not null");
		if (id != null && !id.equalsIgnoreCase("null")) {
			condicao.append(" and o.id = " + id);
		}

		if (descricao != null && !descricao.equalsIgnoreCase("null")) {
			condicao.append(" and upper(o.descricao) like '" + descricao.toUpperCase());
			condicao.append("%'");
		}

		if (precoCompra != null && !precoCompra.equalsIgnoreCase("null")) {
			condicao.append(" and o.precoCompra = " + precoCompra);
		}

		if (precoVenda != null && !precoVenda.equalsIgnoreCase("null")) {
			condicao.append(" and o.precoVenda = " + precoVenda);
		}

		return dao.getListByCond(condicao.toString());
	}

}
