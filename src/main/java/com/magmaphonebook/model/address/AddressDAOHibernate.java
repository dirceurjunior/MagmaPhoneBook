/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magmaphonebook.model.address;

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
public class AddressDAOHibernate implements AddressDAO {

    private Session session;

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void salvar(Address endereco) {
        this.session.save(endereco);
    }

    @Override
    public void atualizar(Address endereco) {
        this.session.update(endereco);
    }

    @Override
    public void excluir(Address endereco) {
        this.session.delete(endereco);
    }

    @Override
    public Address porId(Integer id) {
        Criteria criteria = this.session.createCriteria(Address.class).add(Restrictions.eq("id", id));
        Address endereco = (Address) criteria.uniqueResult();
        return endereco;
    }

    @Override
    public Address porNome(String nome) {
        Criteria criteria = this.session.createCriteria(Address.class).add(Restrictions.eq("logradouro", nome));
        Address endereco = (Address) criteria.uniqueResult();
        return endereco;
    }

    @Override
    public List<Address> listarTodos() {
        return this.session.createCriteria(Address.class).addOrder(Order.asc("logradouro")).list();
    }

    @Override
    public List<Address> listarPorNome(String nome) {
        return this.session.createCriteria(Address.class).add(Restrictions.like("logradouro", nome, MatchMode.ANYWHERE)).addOrder(Order.asc("logradouro")).list();
    }

    @Override
    public Integer retornaUltimoCodigo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
