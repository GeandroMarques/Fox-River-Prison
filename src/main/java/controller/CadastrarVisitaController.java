package controller;

import dao.VisitaDAO;
import models.Visita;

public class CadastrarVisitaController {

    public CadastrarVisitaController() {
        Visita v = new Visita(1, 1, "vasco", "00-00-0000:00:00");
        VisitaDAO vDAO = new VisitaDAO();
        vDAO.registrarVisita(v);
    }
}
