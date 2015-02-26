/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magmaphonebook.model.contact;

import com.magmaphonebook.util.DAOFactory;
import java.util.List;

/**
 *
 * @author Dirceu Junior
 */
public class ContactRN {

   private final ContactDAO contactDAO;

   public ContactRN() {
      this.contactDAO = DAOFactory.createContactDAO();
   }

   public void save(Contact contact) {
      this.contactDAO.save(contact);
   }

   public void update(Contact contact) {
      this.contactDAO.update(contact);
   }

   public void delete(Contact contact) {
      this.contactDAO.delete(contact);
   }

   public List<Contact> listAll() {
      return this.contactDAO.listAll();
   }

   public List<Contact> listByName(String name) {
      return this.contactDAO.listByName(name);
   }

   public int getLastId() {
      return this.contactDAO.getLastId();
   }

   public Contact findById(int id) {
      return this.contactDAO.findById(id);
   }

   public Contact findByName(String name) {
      return this.contactDAO.findByName(name);
   }

   public Contact findByCPF(String cpf) {
      return this.contactDAO.findByCPF(cpf);
   }

   public List<Contact> findByNameSimple(String name) {
      return this.contactDAO.findByNameSimple(name);
   }
}
