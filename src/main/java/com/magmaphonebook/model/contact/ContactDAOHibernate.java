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
   public void save(Contact cliente) {
      this.session.save(cliente);
   }

   @Override
   public void update(Contact cliente) {
      this.session.update(cliente);
   }

   @Override
   public void delete(Contact cliente) {
      session.delete(cliente);
   }

   @Override
   public List<Contact> listAll() {
      return this.session.createCriteria(Contact.class).addOrder(Order.asc("name")).list();
   }

   @Override
   public List<Contact> listByName(String name) {
      Criteria criteria = this.session.createCriteria(Contact.class)
              .add(Restrictions.like("name", name, MatchMode.ANYWHERE))
              .addOrder(Order.asc("name"));
      //criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
      return criteria.list();
   }

   @Override
   public Integer getLastId() {
      int last = 0;
      Criteria criteria = this.session.createCriteria(Contact.class).setProjection(Projections.max("id"));
      if (criteria.uniqueResult() == null) {
         return last;
      } else {
         last = (Integer) criteria.uniqueResult();
      }
      return last;
   }

   @Override
   public Contact findById(Integer id) {
      Criteria criteria = this.session.createCriteria(Contact.class).add(Restrictions.eq("id", id));
      Contact contact = (Contact) criteria.uniqueResult();
      return contact;
   }

   @Override
   public Contact findByName(String name) {
      Criteria criteria = this.session.createCriteria(Contact.class).add(Restrictions.eq("name", name));
      Contact contact = (Contact) criteria.uniqueResult();
      return contact;
   }

   @Override
   public Contact findByCPF(String cpf) {
      Criteria criteria = this.session.createCriteria(Contact.class).add(Restrictions.eq("cpf", cpf));
      Contact contact = (Contact) criteria.uniqueResult();
      return contact;
   }

   @Override
   public List<Contact> findByNameSimple(String name) {

//      Criteria lista = session.createCriteria(Paciente.class, "p")
//              .setProjection(Projections.projectionList()
//                      .add(Projections.property("p.id").as("id"))
//                      .add(Projections.property("p.name").as("name")))
//              .add(Restrictions.like("name", name, MatchMode.ANYWHERE));
//      return lista.list();
      Criteria criteria = this.session.createCriteria(Contact.class);
      ProjectionList p1 = Projections.projectionList();
      p1.add(Projections.property("id"));
      p1.add(Projections.property("name"));
      criteria.setProjection(p1);
      criteria.add(Restrictions.like("name", name, MatchMode.ANYWHERE));
      criteria.addOrder(Order.asc("name"));
      //criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);

      List results = criteria.list();

      Contact p = null;
      List<Contact> result_list = null;
      List<String> result_lista = null;
      for (Object objects : results) {
         Object[] o = (Object[]) objects;
         System.out.println("Salaries in " + o[1].toString() + " state: " + o[0]);
            //Integer result_id = (Integer) o[0];
         //String result_name = (String) o[1];
         //System.out.println("names " + result_name + " state: " + result_id);
      }

      //return (List<Paciente>) criteria.list();
      return results;

   }

}
