package Model;

import java.math.BigDecimal;

public class ProdutoModel {
    private String nome;
    private BigDecimal preço;

    public ProdutoModel(String nome, BigDecimal preço) {
        this.nome = nome;
        this.preço = preço;
    }

    public ProdutoModel() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreço() {
        return preço;
    }

    public void setPreço(BigDecimal preço) {
        this.preço = preço;
    }
}
