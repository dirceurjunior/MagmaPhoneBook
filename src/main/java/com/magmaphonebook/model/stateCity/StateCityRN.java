/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magmaphonebook.model.stateCity;

import com.magmaphonebook.util.DAOFactory;
import java.util.List;

/**
 *
 * @author Dirceu Junior
 */
public class StateCityRN {
    
    private final StateCityDAO stateCityDAO;
    
    public StateCityRN(){
        this.stateCityDAO = DAOFactory.createStateCityDAO();
    }

    public List<State> listarEstados(){
        return this.stateCityDAO.listarEstados();
    }
    
    public List<City> listarMunicipios(){
        return this.stateCityDAO.listarMunicipios();
    }
    
    public List<City> buscarPorUF(Integer codigo){
        return this.stateCityDAO.buscarPorUF(codigo);
    }
}
