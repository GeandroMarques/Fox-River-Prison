package models;

public class Visita extends Prisioneiro {
    private int id_visita;
    private String nome_visitante;
    private String data_visita;

    public Visita(int id_visita, int id_pessoa, String nome_visitante, String data_visita) {
        super(id_pessoa);
        this.id_visita = id_visita;
        this.nome_visitante = nome_visitante;
        this.data_visita = data_visita;
    }

    public int getId_visita() {
        return id_visita;
    }

    public void setId_visita(int id_visita) {
        this.id_visita = id_visita;
    }

    public String getNome_visitante() {
        return nome_visitante;
    }

    public void setNome_visitante(String nome_visitante) {
        this.nome_visitante = nome_visitante;
    }

    public String getData_visita() {
        return data_visita;
    }

    public void setData_visita(String data_visita) {
        this.data_visita = data_visita;
    }
}
