package controller;

import dao.PrisioneiroDAO;
import io.javalin.Javalin;
import models.Prisioneiro;
import io.javalin.http.Context;

import java.util.ArrayList;

public class ListarPrisioneirosController {
    private Javalin app;

    public ListarPrisioneirosController() {
        this.app = ProvedorApp.getInstance().getApp();
        rota();
    }

    public void rota() {
        this.app.post("/get_lista_presos", this::listarPresos);
    }

    public void listarPresos(Context ctx) {
        PrisioneiroDAO pDAO = new PrisioneiroDAO();
        ArrayList<Prisioneiro> lista = pDAO.listarPrisioneiros();
        ctx.json(lista);
    }
}
