/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magmaphonebook.model.phone;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Dirceu Junior
 */
public class PhoneDAOHibernate implements PhoneDAO {

    private Session session;

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void save(Phone phone) {
        this.session.save(phone);
    }

    @Override
    public void update(Phone phone) {
        this.session.update(phone);
    }

    @Override
    public void delete(Phone phone) {
        this.session.delete(phone);
    }

    @Override
    public Phone findById(Integer id) {
        Criteria criteria = this.session.createCriteria(Phone.class).add(Restrictions.eq("id", id));
        Phone phone = (Phone) criteria.uniqueResult();
        return phone;
    }

    @Override
    public List<Phone> listAll() {
        return this.session.createCriteria(Phone.class).list();
    }

}
