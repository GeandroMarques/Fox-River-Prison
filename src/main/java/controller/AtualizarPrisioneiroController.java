package controller;

import dao.PessoaDAO;
import dao.PrisioneiroDAO;
import io.javalin.Javalin;
import io.javalin.http.Context;
import models.Pessoa;
import models.Prisioneiro;

import java.util.Map;


public class AtualizarPrisioneiroController {
    private Javalin app;
    public AtualizarPrisioneiroController() {
        this.app = ProvedorApp.getInstance().getApp();
        rota();
       /* PrisioneiroDAO pDAO = new PrisioneiroDAO();
        Prisioneiro p = new Prisioneiro("vasco", "12/34/56", 12, "12/34/56", 10);
        pDAO.editarPrisioneiro(p);
        */
    }
    public void rota(){
        this.app.post("/atualizar_preso", this::atualizar_preso);
    }

    public void atualizar_preso(Context ctx){
        Map json = ctx.bodyAsClass(Map.class);
        Integer id = (Integer) json.get("id");
        String nome = (String) json.get("nome");
        String data_nascimento = (String) json.get("data_nascimento");
        int pena_meses = (Integer) json.get("pena_meses");
        int cela = (Integer) json.get("cela");

        PessoaDAO pessoaDAO = new PessoaDAO();
        Pessoa pessoa = new Pessoa(id, nome, data_nascimento);
        pessoaDAO.editarPessoa(pessoa);

        PrisioneiroDAO pDAO = new PrisioneiroDAO();
        Prisioneiro p = new Prisioneiro(id, nome, data_nascimento,pena_meses, cela);
        pDAO.editarPrisioneiro(p);
    }
}
