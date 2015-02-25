/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magmaphonebook.model.contact;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Dirceu Junior
 */
public class ContactDAOHibernate implements ContactDAO {

    private Session session;

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void salvar(Contact cliente) {
        this.session.save(cliente);
    }

    @Override
    public void atualizar(Contact cliente) {
        this.session.update(cliente);
    }

    @Override
    public void excluir(Contact cliente) {
        session.delete(cliente);
    }

    @Override
    public List<Contact> listarTodos() {
        return this.session.createCriteria(Contact.class).addOrder(Order.asc("nome")).list();
    }

    @Override
    public List<Contact> listarPorNome(String nome) {
        Criteria criteria = this.session.createCriteria(Contact.class)
                .add(Restrictions.like("nome", nome, MatchMode.ANYWHERE))
                .addOrder(Order.asc("nome"));
        //criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        return criteria.list();
    }

    @Override
    public Integer retornaUltimoId() {
        int ultimo = 0;
        Criteria criteria = this.session.createCriteria(Contact.class).setProjection(Projections.max("id"));
        if (criteria.uniqueResult() == null) {
            return ultimo;
        } else {
            ultimo = (Integer) criteria.uniqueResult();
        }
        return ultimo;
    }

    @Override
    public Contact porId(Integer id) {
        Criteria criteria = this.session.createCriteria(Contact.class).add(Restrictions.eq("id", id));
        Contact paciente = (Contact) criteria.uniqueResult();
        return paciente;
    }

    @Override
    public Contact porNome(String nome) {
        Criteria criteria = this.session.createCriteria(Contact.class).add(Restrictions.eq("nome", nome));
        Contact paciente = (Contact) criteria.uniqueResult();
        return paciente;
    }

    @Override
    public Contact porCPF(String cpf) {
        Criteria criteria = this.session.createCriteria(Contact.class).add(Restrictions.eq("cpf", cpf));
        Contact paciente = (Contact) criteria.uniqueResult();
        return paciente;
    }

    @Override
    public List<Contact> porNomeSimples(String nome) {

//      Criteria lista = session.createCriteria(Paciente.class, "p")
//              .setProjection(Projections.projectionList()
//                      .add(Projections.property("p.id").as("id"))
//                      .add(Projections.property("p.nome").as("nome")))
//              .add(Restrictions.like("nome", nome, MatchMode.ANYWHERE));
//      return lista.list();
        Criteria criteria = this.session.createCriteria(Contact.class);
        ProjectionList p1 = Projections.projectionList();
        p1.add(Projections.property("id"));
        p1.add(Projections.property("nome"));
        criteria.setProjection(p1);
        criteria.add(Restrictions.like("nome", nome, MatchMode.ANYWHERE));
        criteria.addOrder(Order.asc("nome"));
        //criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);

        List results = criteria.list();

        Contact p = null;
        List<Contact> result_list = null;
        List<String> result_lista = null;
        for (Object objects : results) {
            Object[] o = (Object[]) objects;
            System.out.println("Salaries in " + o[1].toString() + " state: " + o[0]);
            //Integer result_id = (Integer) o[0];
            //String result_nome = (String) o[1];
            //System.out.println("nomes " + result_nome + " state: " + result_id);
        }

        //return (List<Paciente>) criteria.list();
        return results;

    }

}
