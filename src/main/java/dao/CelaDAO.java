package dao;

import models.Cela;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CelaDAO {
    private Connection conexao;
    private String query;
    private PreparedStatement ps;

    public CelaDAO() {
        conexao = ConexaoMySQL.getConexao().getConnection();
    }

    public void cadastrarCela(Cela c) {
        query = "INSERT INTO cela (bloco, capacidade, vagas_utilizadas) VALUES (?, ?)";

        try{
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setInt(1, c.getBloco());
            stmt.setInt(2, c.getCapacidade());
            stmt.setInt(3, c.getVagas_utilizadas());
            stmt.executeUpdate();
            stmt.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Cela> listarCelas() {
        query = "SELECT * FROM cela";
        ArrayList<Cela> lista = new ArrayList<>();
        try {
            PreparedStatement stmt = conexao.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                int id_cela = rs.getInt("id_cela");
                int bloco = rs.getInt("bloco");
                int capacidade = rs.getInt("capacidade");
                int vagas_utilizadas = rs.getInt("vagas_utilizadas");
                Cela c = new Cela(id_cela, bloco, capacidade, vagas_utilizadas);
                lista.add(c);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public void atualizarCela(Cela c) {
        query = "UPDATE cela SET bloco=?, capacidade=?, vagas_utilizadas=? WHERE id_cela =?";

        try{
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setInt(1, c.getBloco());
            stmt.setInt(2, c.getCapacidade());
            stmt.setInt(3, c.getId_cela());
            stmt.setInt(4, c.getVagas_utilizadas());
            stmt.executeUpdate();
            stmt.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void deletarCela(int id_cela) {
        query = "DELETE FROM cela WHERE id_cela = ?";

        try{
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setInt(1, id_cela);
            stmt.executeUpdate();
            stmt.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }



}
