package controller;

import dao.PessoaDAO;

public class DeletarPessoaController {

    public DeletarPessoaController(Integer id) {
        PessoaDAO pDAO = new PessoaDAO();
        pDAO.deletarPessoa(id); //Aqui recebe o id do usuário q vai ser deletado
    }
}
