package com.pedro.painelsrv.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;

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

    public ProdutoImagem(Integer id, Boolean principal, String uriImagem) {
        this.id = id;
        this.principal = principal;
        this.uriImagem = uriImagem;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_imagem_seq")
    @SequenceGenerator(name = "global_seq", sequenceName = "produto_imagem_seq", allocationSize = 1)
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

    @Column(name = "URI_IMAGEM",length = 300)
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
}
