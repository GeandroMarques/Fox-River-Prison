package dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class ConexaoMySQL {
    private static ConexaoMySQL conexaoMySQL;
    private Connection conexao;

    private ConexaoMySQL(){
        try {
            conexao = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/foxriver?useSSL=false&allowPublicKeyRetrieval=true", "teste1", "test1");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static ConexaoMySQL getConexao() {
        if (conexaoMySQL == null) {
            conexaoMySQL = new ConexaoMySQL();
        }
        return conexaoMySQL;
    }

    public Connection getConnection() {
        return this.conexao;
    }
}
