package controller;

import dao.PessoaDAO;
import models.Pessoa;

public class CadastrarPessoaController {

    public CadastrarPessoaController() {
        Pessoa p = new Pessoa(1, "aqui recebe os dados do krl do js, boa sorte pra quem for fazer", "1223123");
        PessoaDAO pDAO = new PessoaDAO();
        //pDAO.cadastrarPessoa(p);
    }
}
