package models;

public class Pessoa {
    private int id_pessoa;
    private String nome;
    private String data_nascimento;

    public Pessoa (int id_pessoa, String nome, String data_nascimento) {
        this.id_pessoa = id_pessoa;
        this.nome = nome;
        this.data_nascimento = data_nascimento;
    }

    public Pessoa (String nome, String data_nascimento) {
        this.nome = nome;
        this.data_nascimento = data_nascimento;
    }


    public Pessoa (int id_pessoa){
        this.id_pessoa = id_pessoa;
    }

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

}
