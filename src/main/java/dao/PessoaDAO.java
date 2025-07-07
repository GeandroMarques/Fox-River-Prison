package dao;

import models.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PessoaDAO {
    private Connection conexao;
    private String query;
    private PreparedStatement ps;

    public PessoaDAO () {
        conexao = ConexaoMySQL.getConexao().getConnection();
    }


    public void criarPessoa(Pessoa p) {
        query = "INSERT INTO pessoa (nome, data_nascimento) VALUES (?, ?)";

        try {
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getData_nascimento());
            stmt.executeUpdate();
            stmt.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Integer pegarPessoa(String nome){
        this.query = "SELECT id_pessoa FROM pessoa WHERE nome = ?";
        Integer id = null;
        try {
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            id = rs.getInt("id_pessoa");
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public void deletarPessoa(int id_pessoa) {
        query = "DELETE FROM pessoa WHERE id_pessoa = ?";

        try {
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setInt(1, id_pessoa);
            stmt.executeUpdate();
            stmt.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void editarPessoa (Pessoa p) {
        query = "UPDATE pessoa SET nome=?, data_nascimento=? WHERE id_pessoa=?";

        try {
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getData_nascimento());
            stmt.setInt(3, p.getId_pessoa());
            stmt.executeUpdate();
            stmt.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
