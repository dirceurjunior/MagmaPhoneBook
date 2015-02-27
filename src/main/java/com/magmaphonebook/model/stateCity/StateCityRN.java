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

    public StateCityRN() {
        this.stateCityDAO = DAOFactory.createStateCityDAO();
    }

    public List<State> listStates() {
        return this.stateCityDAO.listStates();
    }

    public List<City> listCities() {
        return this.stateCityDAO.listCities();
    }

    public List<City> findByUF(Integer id) {
        return this.stateCityDAO.findByUF(id);
    }
}
