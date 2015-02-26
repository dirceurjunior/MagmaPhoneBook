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
   public void save(Address address) {
      this.session.save(address);
   }

   @Override
   public void update(Address address) {
      this.session.update(address);
   }

   @Override
   public void delete(Address address) {
      this.session.delete(address);
   }

   @Override
   public Address findById(Integer id) {
      Criteria criteria = this.session.createCriteria(Address.class).add(Restrictions.eq("id", id));
      Address address = (Address) criteria.uniqueResult();
      return address;
   }

   @Override
   public Address findByName(String name) {
      Criteria criteria = this.session.createCriteria(Address.class).add(Restrictions.eq("street", name));
      Address address = (Address) criteria.uniqueResult();
      return address;
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
   public Integer getLastRecord() {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

}
