package controller;

import dao.VisitaDAO;
import io.javalin.Javalin;
import models.Visita;
import io.javalin.http.Context;

import java.util.ArrayList;

public class ListarVisitasController {
    private Javalin app;

    public ListarVisitasController() {
        this.app = ProvedorApp.getInstance().getApp();
        rota();
    }

    public void rota() {
        this.app.post("/get_lista_visitas", this::listarVisitas);
    }

    public void listarVisitas(Context ctx) {
        VisitaDAO vDAO = new VisitaDAO();
        ArrayList<Visita> lista = vDAO.listarVisitas();

        ctx.json(lista);
    }
}
