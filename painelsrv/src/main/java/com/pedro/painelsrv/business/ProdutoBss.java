package com.pedro.painelsrv.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.pedro.painelsrv.domain.Produto;
import com.pedro.painelsrv.util.SQLBuilder;
import static com.pedro.painelsrv.util.Funcoes.validateUrlParam;

@Stateless
public class ProdutoBss extends Bss<Produto> {

	private static final long serialVersionUID = 1L;

	@EJB
	ProdutoImagemBss imagemBss;

	public List<Produto> getList() {
		return dao.getList();
	}

	public Produto create(Produto entity) {
		entity.getImagens().forEach(e -> e.setProduto(entity));
		dao.persit(entity);
		return dao.getEntity(entity.getId());
	}

	public Produto update(Produto entity) {

		dao.merge(entity);
		return entity;
	}

	public List<Produto> getListByCond(String id, String descricao, String precoCompra, String precoVenda,
			String dataDe, String dataAte) {

		SQLBuilder sql = new SQLBuilder("Prodt");

		sql.appendWhere(" i.principal=1");
		if (!validateUrlParam(id)) {
			sql.appendWhere(" o.id = " + id);
		}

		if (!validateUrlParam(descricao)) {
			sql.appendWhere(" upper(o.descricao) like '" + descricao.toUpperCase() + "%'");
		}

		if (!validateUrlParam(precoCompra)) {
			sql.appendWhere("  o.precoCompra= " + precoCompra);
		}
		if (!validateUrlParam(precoVenda)) {
			sql.appendWhere(" o.precoVenda= " + precoVenda);
		}

		if (!validateUrlParam(dataDe)) {
			sql.appendWhere(" trunc(o.dataCadastro) >= " + "to_date('" + dataDe + "', 'DD/MM/YYYY')");
		}

		if (!validateUrlParam(dataAte)) {
			sql.appendWhere(" trunc(o.dataCadastro)  <= " + "to_date('" + dataAte + "', 'DD/MM/YYYY')");
		}

		return dao.getListJoin(" join fetch o.imagens i ");
	}

	public boolean delete(Integer pk) {
		dao.delete(pk);
		return true;
	}

	public Produto getEntity(Integer id) {
		
		return dao.getEntityByCond(" join fetch o.imagens where o.id=" +id);
	}

}
