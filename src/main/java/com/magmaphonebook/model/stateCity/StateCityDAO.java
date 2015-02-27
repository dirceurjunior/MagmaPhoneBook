/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magmaphonebook.model.stateCity;

import java.util.List;

/**
 *
 * @author Dirceu Junior
 */
public interface StateCityDAO {

    public List<City> listCities();

    public List<State> listStates();

    public List<City> findByUF(Integer id);

}
