package controller;

import dao.PrisioneiroDAO;
import io.javalin.Javalin;
import io.javalin.http.Context;

import java.util.Map;

public class DeletarPrisioneiroController {
    private Javalin app;

    public DeletarPrisioneiroController() {
        this.app = ProvedorApp.getInstance().getApp();
        rota();
    }

    public void rota(){
        this.app.post("/deletar_preso", this::deletar_preso);
    }

    public void deletar_preso(Context ctx){
        Map json = ctx.bodyAsClass(Map.class);
        PrisioneiroDAO pDAO = new PrisioneiroDAO();
        Integer id = (Integer) json.get("id");
        pDAO.deletarPrisioneiro(id);
        new DeletarPessoaController(id);
    }
}
