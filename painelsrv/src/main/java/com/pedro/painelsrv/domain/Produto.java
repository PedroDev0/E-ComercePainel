package com.pedro.painelsrv.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "PRODUTO")
@Table(name = "PRODUTO")
public class Produto {

	private Integer id;
	private String descricao;
	private BigDecimal precoCompra;
	private BigDecimal precoVenda;
	private Date dataCadastro;
	private String uriImagePrincipal;
	
	public Produto() {
	}

	@Id
	@Column(name = "ID")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "DESCRICAO")
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Column(name = "PRECO_COMPRA")
	public BigDecimal getPrecoCompra() {
		return precoCompra;
	}

	public void setPrecoCompra(BigDecimal precoCompra) {
		this.precoCompra = precoCompra;
	}

	@Column(name = "PRECO_VENDA")
	public BigDecimal getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(BigDecimal precoVenda) {
		this.precoVenda = precoVenda;
	}

	@Column(name = "DATA_CADASTRO")
	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getUriImagePrincipal() {
		return uriImagePrincipal;
	}

	public void setUriImagePrincipal(String uriImagePrincipal) {
		this.uriImagePrincipal = uriImagePrincipal;
	}


}
