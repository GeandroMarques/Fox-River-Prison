package controller;

import dao.FuncionarioDAO;

public class DeletarFuncionarioController {

    public DeletarFuncionarioController() {
        FuncionarioDAO fDAO = new FuncionarioDAO();
        fDAO.deletarFuncionario(19191919); //Aqui recebe o id do usuário q vai ser deletado
    }
}
