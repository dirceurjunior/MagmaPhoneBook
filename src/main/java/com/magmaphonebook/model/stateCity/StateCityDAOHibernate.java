/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magmaphonebook.model.stateCity;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Dirceu Junior
 */
public class StateCityDAOHibernate implements StateCityDAO {

    private Session session;

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public List<State> listarEstados() {
        Criteria l = this.session.createCriteria(State.class).addOrder(Order.asc("nome"));
        List<State> lista = l.list();
        return lista;
    }

    @Override
    public List<City> listarMunicipios() {
        return this.session.createCriteria(City.class).addOrder(Order.asc("nome")).list();
    }

    @Override
    public List<City> buscarPorUF(Integer id) {
        Criteria criteria = this.session.createCriteria(City.class);
        criteria.add(Restrictions.eq("estado_id", String.valueOf(id)));
        return criteria.list();
    }
}
