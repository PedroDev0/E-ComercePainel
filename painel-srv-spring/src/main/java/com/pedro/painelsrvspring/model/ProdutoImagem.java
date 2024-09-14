package com.pedro.painelsrvspring.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.pedro.painelsrvspring.dto.ProdutoImagemDetailsDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity(name = "PRODUTO_IMAGEM")
@Table(name = "PRODUTO_IMAGEM")
public class ProdutoImagem implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Boolean principal;
	private String uriImagem;
	@JsonBackReference
	private Produto produto;

	public ProdutoImagem() {

	}

	public ProdutoImagem(ProdutoImagemDetailsDTO dto) {
		this.id = dto.id();
		this.principal = dto.principal();
		this.uriImagem = dto.uriImagem();
	}

	public ProdutoImagem(Integer id, Boolean principal, String uriImagem) {
		this.id = id;
		this.principal = principal;
		this.uriImagem = uriImagem;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "PRINCIPAL", length = 1)
	public Boolean getPrincipal() {
		return principal;
	}

	public void setPrincipal(Boolean principal) {
		this.principal = principal;
	}

	@Column(name = "URI_IMAGEM", length = 300)
	public String getUriImagem() {
		return uriImagem;
	}

	public void setUriImagem(String uriImagem) {
		this.uriImagem = uriImagem;
	}

	@ManyToOne
	@JoinColumn(name = "PRODUTO_ID", nullable = false)
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public void update(ProdutoImagemDetailsDTO dtoImg) {

		this.principal = dtoImg.principal();
		this.uriImagem = dtoImg.uriImagem();
	}
}
