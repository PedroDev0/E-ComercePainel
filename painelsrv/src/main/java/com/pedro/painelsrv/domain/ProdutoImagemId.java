package com.pedro.painelsrv.domain;
// Generated 1 de jul. de 2024 15:58:25 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ProdutoImagemId generated by hbm2java
 */
@Embeddable
public class ProdutoImagemId implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private int produtoId;

	public ProdutoImagemId() {
	}

	public ProdutoImagemId(int id, int produtoId) {
		this.id = id;
		this.produtoId = produtoId;
	}

	@Column(name = "ID", nullable = false, precision = 9, scale = 0)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "PRODUTO_ID", nullable = false, precision = 9, scale = 0)
	public int getProdutoId() {
		return this.produtoId;
	}

	public void setProdutoId(int produtoId) {
		this.produtoId = produtoId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ProdutoImagemId))
			return false;
		ProdutoImagemId castOther = (ProdutoImagemId) other;

		return (this.getId() == castOther.getId()) && (this.getProdutoId() == castOther.getProdutoId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getId();
		result = 37 * result + this.getProdutoId();
		return result;
	}

}
