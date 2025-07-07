package models;

public class Cela {
    private int id_cela;
    private int bloco;
    private int capacidade;
    private int vagas_utilizadas;

    public Cela(int id_cela, int bloco, int capacidade, int vagas_utilizadas) {
        this.id_cela = id_cela;
        this.bloco = bloco;
        this.capacidade = capacidade;
        this.vagas_utilizadas = vagas_utilizadas;
    }

    public int getId_cela() {
        return id_cela;
    }

    public void setId_cela(int id_cela) {
        this.id_cela = id_cela;
    }

    public int getBloco() {
        return bloco;
    }

    public void setBloco(int bloco) {
        this.bloco = bloco;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getVagas_utilizadas() {
        return vagas_utilizadas;
    }

    public void setVagas_utilizadas(int vagas_utilizadas) {
        this.vagas_utilizadas = vagas_utilizadas;
    }
}
