package controller;

import dao.CelaDAO;
import models.Cela;

public class CadastrarCelaController {

    public CadastrarCelaController() {
        Cela c = new Cela(1, 1, 121, 11);
        CelaDAO cDAO = new CelaDAO();
        cDAO.cadastrarCela(c);
    }
}
