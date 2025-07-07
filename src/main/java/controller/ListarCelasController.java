package controller;

import dao.CelaDAO;

import io.javalin.Javalin;
import io.javalin.http.Context;
import models.Cela;

import java.util.ArrayList;

public class ListarCelasController {
    private Javalin app;

    public ListarCelasController() {
        this.app = ProvedorApp.getInstance().getApp();
        rota();
    }

    public void rota() {
        this.app.post("get_lista_celas", this::listarCelas);
    }

    public void listarCelas(Context ctx) {
        CelaDAO cDAO = new CelaDAO();
        ArrayList<Cela> lista = cDAO.listarCelas();

        ctx.json(lista);
    }
}
