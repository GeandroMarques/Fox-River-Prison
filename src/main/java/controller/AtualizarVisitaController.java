package controller;

import dao.VisitaDAO;
import models.Visita;

public class AtualizarVisitaController {

    public AtualizarVisitaController() {
        VisitaDAO vDAO = new VisitaDAO();
        Visita v = new Visita(1, 1, "vasco", "11/22/33");
        vDAO.atualizarVisita(v);
    }
}
