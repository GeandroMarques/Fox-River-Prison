package models;

public class Prisioneiro extends Pessoa {
    private int pena_meses;
    private String data_entrada;
    private int cela;

    public Prisioneiro (int id_pessoa, String nome, String data_nascimento, int pena_meses, String data_entrada, int cela) {
        super(id_pessoa, nome, data_nascimento);
        this.pena_meses = pena_meses;
        this.data_entrada = data_entrada;
        this.cela = cela;
    }

    public Prisioneiro (int id_pessoa, String nome, String data_nascimento, int pena_meses, int cela) {
        super(id_pessoa, nome, data_nascimento);
        this.pena_meses = pena_meses;
        this.cela = cela;
    }
    public Prisioneiro (String nome, String data_nascimento, int pena_meses, int cela) {
        super(nome, data_nascimento);
        this.pena_meses = pena_meses;
        this.cela = cela;
    }


    public Prisioneiro (int id_pessoa){
        super(id_pessoa);
    }

    public int getPena_meses() {
        return pena_meses;
    }

    public void setPena_meses(int pena_anos) {
        this.pena_meses = pena_anos;
    }

    public String getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(String data_entrada) {
        this.data_entrada = data_entrada;
    }

    public int getCela() {
        return cela;
    }

    public void setCela(int cela) {
        this.cela = cela;
    }
}
