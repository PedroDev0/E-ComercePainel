package com.pedro.painelsrv.business;

import static com.pedro.painelsrv.util.Funcoes.validateUrlParam;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.pedro.painelsrv.domain.Produto;
import com.pedro.painelsrv.util.SQLBuilder;

@Stateless
public class ProdutoBss extends Bss<Produto> {

	private static final long serialVersionUID = 1L;

	@EJB
	ProdutoImagemBss imagemBss;

	public List<Produto> getList() {
		return dao.getList();
	}

	public Produto create(Produto entity) {
		entity.getImagens().forEach(e-> e.setProduto(entity));
		dao.persit(entity);
		return dao.getEntity(entity.getId());
	}

	public Produto update(Produto entity) {

		dao.merge(entity);
		return entity;
	}


	public List<Produto> getListByCond(String id, String descricao, String precoCompra, String precoVenda,
			String dataDe, String dataAte) {

		SQLBuilder sql = new SQLBuilder("PRODUTO");

		if (!validateUrlParam(id)) {
			sql.appendWhere(" PRODUTO.ID = " + id);
		}

		if (!validateUrlParam(descricao)) {
			sql.appendWhere(" upper(PRODUTO.DESCRICAO) like '" + descricao.toUpperCase() + "%'");
		}

		if (!validateUrlParam(precoCompra)) {
			sql.appendWhere("  PRODUTO.PRECO_COMPRA= " + precoCompra);
		}
		if (!validateUrlParam(precoVenda)) {
			sql.appendWhere(" PRODUTO.PRECO_VENDA= " + precoVenda);
		}

		if (!validateUrlParam(dataDe)) {
			sql.appendWhere(" trunc(PRODUTO.DATA_CADASTRO) >= " + "to_date('" + dataDe + "', 'DD/MM/YYYY')");
		}

		if (!validateUrlParam(dataAte)) {
			sql.appendWhere(" trunc(PRODUTO.DATA_CADASTRO)  <= " + "to_date('" + dataAte + "', 'DD/MM/YYYY')");
		}

		return dao.getListByCond(sql.toWhere());
	}

	public boolean delete(Integer pk) {
		dao.delete(pk);
		return true;
	}

	public Produto getDTO(Integer id) {
		return dao.getEntity(id);
	}

}
