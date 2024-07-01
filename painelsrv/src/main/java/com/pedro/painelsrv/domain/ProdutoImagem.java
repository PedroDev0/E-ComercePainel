package com.pedro.painelsrv.domain;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * ProdutoImagem generated by hbm2java
 */
@Table(name = "PRODUTO_IMAGEM")
@Entity(name = "PRODUTO_IMAGEM")
public class ProdutoImagem implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProdutoImagemId id;
	private Boolean principal;
	private String uriImagem;

	public ProdutoImagem() {
	}

	public ProdutoImagem(ProdutoImagemId id) {
		this.id = id;
	}

	public ProdutoImagem(ProdutoImagemId id, Boolean principal, String uriImagem) {
		this.id = id;
		this.principal = principal;
		this.uriImagem = uriImagem;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "id", column = @Column(name = "ID", nullable = false, precision = 9, scale = 0)),
			@AttributeOverride(name = "produtoId", column = @Column(name = "PRODUTO_ID", nullable = false, precision = 9, scale = 0)) })
	public ProdutoImagemId getId() {
		return this.id;
	}

	public void setId(ProdutoImagemId id) {
		this.id = id;
	}

	@Column(name = "PRINCIPAL", precision = 1, scale = 0)
	public Boolean getPrincipal() {
		return this.principal;
	}

	public void setPrincipal(Boolean principal) {
		this.principal = principal;
	}

	@Column(name = "URI_IMAGEM", length = 300)
	public String getUriImagem() {
		return this.uriImagem;
	}

	public void setUriImagem(String uriImagem) {
		this.uriImagem = uriImagem;
	}

}
