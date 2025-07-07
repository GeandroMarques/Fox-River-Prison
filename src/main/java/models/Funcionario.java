package models;

public class Funcionario extends Pessoa {
    private String cargo;

    public Funcionario (String nome, String data_nascimento, String cargo) {
        super(nome, data_nascimento);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
