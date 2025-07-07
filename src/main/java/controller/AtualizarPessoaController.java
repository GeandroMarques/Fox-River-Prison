package controller;

import dao.PessoaDAO;
import models.Pessoa;

public class AtualizarPessoaController {

    public AtualizarPessoaController() {
        PessoaDAO pDAO = new PessoaDAO();
        Pessoa p = new Pessoa(1, "vasco", "12/34/56");
        pDAO.editarPessoa(p);
    }
}
