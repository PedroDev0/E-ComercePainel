package com.pedro.painelsrv.domain;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonManagedReference;

@Entity(name = "PRODUTO")
@Table(name = "PRODUTO")
public class Produto {

    private Integer id;
    private String descricao;
    private BigDecimal precoCompra;
    private BigDecimal precoVenda;
    private Date dataCadastro;
    @JsonManagedReference
    private Set<ProdutoImagem> imagens;

    public Produto() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_seq")
    @SequenceGenerator(name = "produto_seq", sequenceName = "produto_seq", allocationSize = 1)
    @Column(name = "ID", length = 9)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "DESCRICAO", length = 300)
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Column(name = "PRECO_COMPRA" , length = 32 , scale = 16)
    public BigDecimal getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(BigDecimal precoCompra) {
        this.precoCompra = precoCompra;
    }

    @Column(name = "PRECO_VENDA"  , length = 32 , scale = 16)
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<ProdutoImagem> getImagens() {
        return imagens;
    }

    public void setImagens(Set<ProdutoImagem> imagens) {
        this.imagens = imagens;
    }
}
