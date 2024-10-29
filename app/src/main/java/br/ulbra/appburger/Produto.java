package br.ulbra.appburger;

public class Produto {
    private String nome;
    private String descricao;
    private int imagemId;
    private double preco;

    public Produto(String nome, String descricao, int imagemId, double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.imagemId = imagemId;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getImagemId() {
        return imagemId;
    }

    public double getPreco() {
        return preco;
    }
}
