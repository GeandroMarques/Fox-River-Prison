package controller;

import dao.CelaDAO;
import models.Cela;

public class AtualizarCelaController {

    public AtualizarCelaController() {
        CelaDAO cDAO = new CelaDAO();
        Cela c = new Cela(1, 2, 10, 5);
        cDAO.atualizarCela(c);
    }
}
