package controller;

import dao.VisitaDAO;

public class DeletarVisitaController {

    public DeletarVisitaController() {
        VisitaDAO vDAO = new VisitaDAO();
        vDAO.deletarVisita(12312312);
    }
}