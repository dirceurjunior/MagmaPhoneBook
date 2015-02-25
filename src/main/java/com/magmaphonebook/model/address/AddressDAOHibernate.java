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
   public void save(Address endereco) {
      this.session.save(endereco);
   }

   @Override
   public void update(Address endereco) {
      this.session.update(endereco);
   }

   @Override
   public void delete(Address endereco) {
      this.session.delete(endereco);
   }

   @Override
   public Address findById(Integer id) {
      Criteria criteria = this.session.createCriteria(Address.class).add(Restrictions.eq("id", id));
      Address endereco = (Address) criteria.uniqueResult();
      return endereco;
   }

   @Override
   public Address findByName(String name) {
      Criteria criteria = this.session.createCriteria(Address.class).add(Restrictions.eq("street", name));
      Address endereco = (Address) criteria.uniqueResult();
      return endereco;
   }

   @Override
   public List<Address> listAll() {
      return this.session.createCriteria(Address.class).addOrder(Order.asc("street")).list();
   }

   @Override
   public List<Address> listByName(String name) {
      return this.session.createCriteria(Address.class).add(Restrictions.like("street", name, MatchMode.ANYWHERE)).addOrder(Order.asc("street")).list();
   }

   @Override
   public Integer retornaUltimoCodigo() {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

}
