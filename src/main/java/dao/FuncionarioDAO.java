package dao;

import models.Funcionario;
import models.Pessoa;
import models.Prisioneiro;

import javax.naming.spi.DirStateFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class FuncionarioDAO {
    private Connection conexao;
    private String query;
    private String query2;
    private ResultSet rs;

    public FuncionarioDAO() {
        conexao = ConexaoMySQL.getConexao().getConnection();
    }

    public void cadastrarFuncionario(Funcionario f){
        query2 = "INSERT INTO funcionario (funcionario_id, cargo) VALUES (?, ?)";

        try{
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setInt(1, f.getId_pessoa());
            stmt.setString(2, f.getCargo());
            stmt.executeUpdate();
            stmt.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Funcionario> listarFuncionarios() {
        query = "SELECT p.id_pessoa, p.nome, p.data_nascimento, f.cargo FROM pessoa p JOIN funcionario f ON p.id_pessoa = f.funcionario_id";
        ArrayList<Funcionario> lista = new ArrayList<>();
        try{
            PreparedStatement stmt = conexao.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                String nome = rs.getString("nome");
                String data_nascimento = rs.getString("data_nascimento");
                String cargo = rs.getString("cargo");
                Funcionario f = new Funcionario(nome, data_nascimento, cargo);
                lista.add(f);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public void editarFuncionario(Funcionario f) {
        query = "UPDATE funcionario SET cargo=? WHERE funcionario_id=?";

        try {
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setString(1, f.getCargo());
            stmt.setInt(2, f.getId_pessoa());
            stmt.executeUpdate();
            stmt.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void deletarFuncionario(int id_pessoa) {
        query = "DELETE FROM funcionario WHERE funcionario_id = ?";

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
