package controller;

import dao.PrisioneiroDAO;
import io.javalin.Javalin;
import io.javalin.http.Context;
import models.Prisioneiro;
import java.util.ArrayList;
import java.util.Map;

public class ListarPresosVisitanteController {
    private Javalin app;

    public ListarPresosVisitanteController(){
        this.app = ProvedorApp.getInstance().getApp();
        rota();
    }

    public void rota(){
        this.app.post("/get_preso", this::listarPresos);
    } 

    public void listarPresos(Context ctx){
        PrisioneiroDAO pDAO = new PrisioneiroDAO();

        Map<String, Object> json = ctx.bodyAsClass(Map.class);
        String nome = (String) json.get("dado");


        ArrayList<Prisioneiro> lista = pDAO.listarPrisioneiros(nome);

        ctx.json(lista);
    }
}
