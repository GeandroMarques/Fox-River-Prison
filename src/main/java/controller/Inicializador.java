package controller;

import io.javalin.Javalin;

public class Inicializador {
    public void inicializar(){
        Javalin app = ProvedorApp.getInstance().getApp();
        new ListarPresosVisitanteController();
        new ListarPrisioneirosController();
        //new AtualizarFuncionarioController();
        new AtualizarPrisioneiroController();
        //new AtualizarVisitaController();
        new CadastrarFuncionarioController();
        new CadastrarPrisioneiroController();
        //new CadastrarVisitaController();
        new DeletarFuncionarioController();
        new DeletarPrisioneiroController();
        new ListarFuncionariosController();
        //new ListarVisitasController();
    }

}
