package controller;

import dao.PessoaDAO;
import dao.PrisioneiroDAO;
import io.javalin.Javalin;
import io.javalin.http.Context;
import models.Pessoa;
import models.Prisioneiro;

import java.util.Map;

public class CadastrarPrisioneiroController {
    private Javalin app;
    public CadastrarPrisioneiroController() {
        this.app = ProvedorApp.getInstance().getApp();
        rota();
    }

    public void rota(){
        this.app.post("/cadastrar_preso", this::cadastrar_preso);
    }

    public void cadastrar_preso(Context ctx){
        Map json = ctx.bodyAsClass(Map.class);
        String nome = (String) json.get("nome");
        String data_nascimento = (String) json.get("data_nascimento");
        int pena_meses = (Integer) json.get("pena_meses");
        int cela = (Integer) json.get("cela");
        Pessoa p = new Pessoa(nome, data_nascimento);
        PessoaDAO pDAO = new PessoaDAO();
        pDAO.criarPessoa(p);

        int id_pessoa = pDAO.pegarPessoa(nome);

        Prisioneiro pr = new Prisioneiro(id_pessoa, nome, data_nascimento, pena_meses, cela);
        PrisioneiroDAO prDAO = new PrisioneiroDAO();
        prDAO.cadastrarPreso(pr);
    }
}
