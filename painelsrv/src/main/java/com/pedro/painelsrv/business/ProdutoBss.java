package com.pedro.painelsrv.business;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.pedro.painelsrv.domain.Produto;
import com.pedro.painelsrv.domain.ProdutoImagem;
import com.pedro.painelsrv.endpoint.dto.ProdutoDto;
import com.pedro.painelsrv.util.Funcoes;
import com.pedro.painelsrv.util.SQLBuilder;

@Stateless
public class ProdutoBss extends Bss<Produto> {

	private static final long serialVersionUID = 1L;

	@EJB
	ProdutoImagemBss imagemBss;

	public List<Produto> getList() {

		return dao.getList();
	}

	public ProdutoDto create(ProdutoDto entityDTO) {

		entityDTO.getProduto().setDataCadastro(new Date());
		entityDTO.getProduto().setId(dao.getNextPk("id"));
		entityDTO.setProduto(dao.persit(entityDTO.getProduto()));

		return entityDTO;
	}

	public ProdutoDto update(ProdutoDto entityDTO) {

		entityDTO.setProduto(dao.merge(entityDTO.getProduto()));
		criaImagens(entityDTO.getImagens(), entityDTO.getProduto().getId());

		return entityDTO;
	}

	private void criaImagens(List<ProdutoImagem> imagens, Integer idProduto) {

		imagemBss.deleteAllByProd(idProduto);
		for (ProdutoImagem produtoImagem : imagens) {
			imagemBss.create(produtoImagem);
		}
	}

	public List<Object[]> getListByCond(String id, String descricao, String precoCompra, String precoVenda,
			String dataDe, String dataAte) {

		SQLBuilder sql = new SQLBuilder("PRODUTO");
		// SELECIONA CAMPOS SELECT NATIVO
		sql.appendField("PRODUTO.ID");
		sql.appendField("URI_PRINCIPAL.URI_IMAGEM");
		sql.appendField("PRODUTO.DESCRICAO");
		sql.appendField("PRODUTO.PRECO_VENDA");
		sql.appendField("PRODUTO.PRECO_COMPRA");

		// INCLUI OS JOINS
		sql.appendJoin(
				" LEFT JOIN ( SELECT PRODUTO_ID, URI_IMAGEM  FROM PRODUTO_IMAGEM WHERE PRINCIPAL = 1) URI_PRINCIPAL ON PRODUTO.ID = URI_PRINCIPAL.PRODUTO_ID ");

		sql.appendWhere(" PRODUTO.ID <> 0");

		if (!Funcoes.validateUrlPram(id)) {
			sql.appendWhere(" PRODUTO.ID = " + id);
		}

		if (!Funcoes.validateUrlPram(descricao)) {
			sql.appendWhere(" and upper(PRODUTO.DESCRICAO) like '" + descricao.toUpperCase());
			sql.appendWhere("%'");
		}

		if (!Funcoes.validateUrlPram(precoCompra)) {
			sql.appendWhere(" and PRODUTO.PRECO_COMPRA= " + precoCompra);
		}
		if (!Funcoes.validateUrlPram(precoVenda)) {
			sql.appendWhere(" and PRODUTO.PRECO_VENDA= " + precoVenda);
		}

		if (!Funcoes.validateUrlPram(dataDe)) {
			sql.appendWhere(" and trunc(PRODUTO.DATA_CADASTRO) >= " + "to_date('" + dataDe + "', 'DD/MM/YYYY')");
		}

		if (!Funcoes.validateUrlPram(dataAte)) {
			sql.appendWhere(" and trunc(PRODUTO.DATA_CADASTRO)  <= " + "to_date('" + dataAte + "', 'DD/MM/YYYY')");
		}

		return dao.getListByNativeQueryTypeless(sql.toString());
	}

	public void delete(Integer pk) {
		dao.delete(pk);
	}

	public ProdutoDto getDTO(Integer id) {

		ProdutoDto dto = new ProdutoDto();
		dto.setProduto(dao.getEntity(id));
		dto.setImagens(imagemBss.getListByProd(id));

		return dto;
	}

}
