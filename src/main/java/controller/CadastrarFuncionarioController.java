package controller;

import dao.FuncionarioDAO;
import io.javalin.Javalin;
import io.javalin.http.Context;
import models.Funcionario;

import java.util.Map;

public class CadastrarFuncionarioController {
    private Javalin app;
    public CadastrarFuncionarioController() {
        this.app = ProvedorApp.getInstance().getApp();
        rota();
    }

    public void rota(){
        this.app.post("/cadastar_funcionario", this::cadastrar_funcionario);
    }

    public void cadastrar_funcionario(Context ctx){
        Map json = ctx.bodyAsClass(Map.class);

        Funcionario f = new Funcionario((String) json.get("nome"), (String) json.get("data_nascimento"), (String) json.get("cargo"));
        FuncionarioDAO fDAO = new FuncionarioDAO();
        fDAO.cadastrarFuncionario(f);
    }
}
