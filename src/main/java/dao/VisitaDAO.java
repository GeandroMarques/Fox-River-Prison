package dao;

import models.Visita;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class VisitaDAO {
    private Connection conexao;
    private String query;
    private PreparedStatement ps;
    private ResultSet rs;

    public VisitaDAO() {
        conexao = ConexaoMySQL.getConexao().getConnection();
    }

    public void registrarVisita(Visita v) {
        query = "INSERT INTO visitas (id_visita, nome_visitante, data_visita) VALUES (?, ?, ?)";

        try{
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setInt(1, v.getId_pessoa());
            stmt.setString(2, v.getNome_visitante());
            stmt.setString(3, v.getData_visita());
            stmt.executeUpdate();
            stmt.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public ArrayList<Visita> listarVisitas() {
        query = "SELECT p.id_pessoa, v.id_visita, v.nome_visitante, v.data_visita JOIN visita v on p.id_pessoa = v.preso_id";
        ArrayList<Visita> lista = new ArrayList<>();
        try{
            PreparedStatement stmt = conexao.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int id_pessoa = rs.getInt("id_pessoa");
                int id_visita = rs.getInt("id_visita");
                String nome_visitante = rs.getString("nome_visitante");
                String data_visita = rs.getString("data_visita");
                Visita v = new Visita(id_visita, id_pessoa, nome_visitante, data_visita);
                lista.add(v);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public void atualizarVisita(Visita v) {
        query = "UPDATE visitas SET preso_id=?, nome_visitante =?, data_visita=? WHERE id_visita=?";

        try {
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setInt(1, v.getId_pessoa());
            stmt.setString(2, v.getNome_visitante());
            stmt.setString(3, v.getData_visita());
            stmt.setInt(4, v.getId_visita());
            stmt.executeUpdate();
            stmt.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void deletarVisita(int id_visita) {
        query="DELETE FROM visitas WHERE id_visita= ?";

        try{
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setInt(1, id_visita);
            stmt.executeUpdate();
            stmt.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
