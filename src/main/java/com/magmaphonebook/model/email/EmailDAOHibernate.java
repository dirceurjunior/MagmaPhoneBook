/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magmaphonebook.model.email;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Dirceu Junior
 */
public class EmailDAOHibernate implements EmailDAO {

    private Session session;

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void save(Email email) {
        this.session.save(email);
    }

    @Override
    public void update(Email email) {
        this.session.update(email);
    }

    @Override
    public void delete(Email email) {
        this.session.delete(email);
    }

    @Override
    public Email findById(Integer id) {
        Criteria criteria = this.session.createCriteria(Email.class).add(Restrictions.eq("id", id));
        Email email = (Email) criteria.uniqueResult();
        return email;
    }

    @Override
    public List<Email> listAll() {
        return this.session.createCriteria(Email.class).addOrder(Order.asc("email")).list();
    }

  

}
