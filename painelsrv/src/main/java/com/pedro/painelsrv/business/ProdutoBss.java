package com.pedro.painelsrv.business;

import java.util.Date;
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

		if (entity.getId() == null ||  entity.getId() <= 0) {
			entity.setDataCadastro(new Date());
			entity.setId(dao.getNextPk("id"));			
		}
		
		return dao.merge(entity);
	}

	public List<Produto> getListByCond(String id, String descricao, String precoCompra, String precoVenda, String dataDe, String dataAte) {

		StringBuilder condicao = new StringBuilder();

		condicao.append(" o.id <> 0");
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
		
		if (dataDe != null && !dataDe.equalsIgnoreCase("null")) {
			condicao.append(" and trunc(o.dataCadastro) >= " +"to_date('" +dataDe+"', 'DD/MM/YYYY')");
		}
		
		if (dataAte != null && !dataAte.equalsIgnoreCase("null")) {
			condicao.append(" and trunc(o.dataCadastro) <= " +"to_date('" +dataAte+"', 'DD/MM/YYYY')");
		}

		return dao.getListByCond(condicao.toString());
	}

	public void delete(Integer pk) {
		dao.delete(pk);
	}

}
