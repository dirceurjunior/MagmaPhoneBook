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

    public List<City> listarMunicipios();

    public List<State> listarEstados();

    public List<City> buscarPorUF(Integer id);

}
