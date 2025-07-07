package controller;

import dao.FuncionarioDAO;
import dao.PrisioneiroDAO;
import io.javalin.Javalin;
import io.javalin.http.Context;
import models.Funcionario;
import models.Prisioneiro;

import java.util.ArrayList;

public class ListarFuncionariosController {
    private Javalin app;

    public ListarFuncionariosController() {
        this.app = ProvedorApp.getInstance().getApp();
        rota();
    }

    public void rota() {
        this.app.post("/get_lista_funcionarios", this::listarFuncionarios);
    }

    public void listarFuncionarios(Context ctx) {
        FuncionarioDAO fDAO = new FuncionarioDAO();
        ArrayList<Funcionario> lista = fDAO.listarFuncionarios();

        ctx.json(lista);

    }
}
