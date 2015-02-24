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
    public void salvar(Phone contato) {
        this.session.save(contato);
    }

    @Override
    public void atualizar(Phone contato) {
        this.session.update(contato);
    }

    @Override
    public void excluir(Phone contato) {
        this.session.delete(contato);
    }

    @Override
    public Phone porId(Integer id) {
        Criteria criteria = this.session.createCriteria(Phone.class).add(Restrictions.eq("id", id));
        Phone contato = (Phone) criteria.uniqueResult();
        return contato;
    }

    @Override
    public List<Phone> listarTodos() {
        return this.session.createCriteria(Phone.class).list();
    }

}
