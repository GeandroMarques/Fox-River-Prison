package dao;

import models.Pessoa;
import models.Prisioneiro;

import java.rmi.server.ExportException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class PrisioneiroDAO {
    private Connection conexao;
    private String query;
    private String query2;
    private PreparedStatement ps;

    public PrisioneiroDAO() {
        conexao = ConexaoMySQL.getConexao().getConnection();
    }

    public void cadastrarPreso(Prisioneiro p) {
        query = "INSERT INTO preso(preso_id, pena_meses, cela) VALUES (?, ?, ?)";

        try{
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setInt(1, p.getId_pessoa());
            stmt.setInt(2, p.getPena_meses());
            stmt.setInt(3, p.getCela());
            stmt.executeUpdate();
            stmt.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Prisioneiro> listarPrisioneiros() {
        query = "SELECT p.id_pessoa, p.nome, p.data_nascimento, pr.pena_meses, pr.data_entrada, pr.cela FROM pessoa p JOIN preso pr ON p.id_pessoa = pr.preso_id";
        ArrayList<Prisioneiro> lista = new ArrayList<>();

        try{
            PreparedStatement stmt = conexao.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                int id = rs.getInt("id_pessoa");
                String nome = rs.getString("nome");
                String data_nascimento = rs.getString("data_nascimento");
                int pena_meses = rs.getInt("pena_meses");
                String data_entrada = rs.getString("data_entrada");
                int cela = rs.getInt("cela");
                Prisioneiro p = new Prisioneiro(id, nome, data_nascimento, pena_meses, data_entrada, cela);
                lista.add(p);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public ArrayList<Prisioneiro> listarPrisioneiros(String nomeProcurado) {
        query = "SELECT p.id_pessoa, p.nome, p.data_nascimento, pr.pena_meses, pr.data_entrada, pr.cela FROM pessoa p JOIN preso pr ON p.id_pessoa = pr.preso_id WHERE p.nome LIKE ?";
        ArrayList<Prisioneiro> lista = new ArrayList<>();

        try{
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setString(1, "%"+ nomeProcurado + "%");
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                int id = rs.getInt("id_pessoa");
                String nome = rs.getString("nome");
                String data_nascimento = rs.getString("data_nascimento");
                int pena_meses = rs.getInt("pena_meses");
                String data_entrada = rs.getString("data_entrada");
                int cela = rs.getInt("cela");
                Prisioneiro p = new Prisioneiro(id, nome, data_nascimento, pena_meses, data_entrada, cela);
                lista.add(p);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }
    public void editarPrisioneiro(Prisioneiro p) {
        query = "UPDATE preso SET pena_meses=?, cela=? WHERE preso_id=?";

        try {
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setInt(1, p.getPena_meses());
            stmt.setInt(2, p.getCela());
            stmt.setInt(3, p.getId_pessoa());
            stmt.executeUpdate();
            stmt.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void deletarPrisioneiro(int id_pessoa) {
        query = "DELETE FROM preso WHERE preso_id = ?";

        try{
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setInt(1, id_pessoa);
            stmt.executeUpdate();
            stmt.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

