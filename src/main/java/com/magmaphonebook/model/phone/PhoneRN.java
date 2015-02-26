/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magmaphonebook.model.phone;

import com.magmaphonebook.util.DAOFactory;
import java.util.List;

/**
 *
 * @author Dirceu Junior
 */
public class PhoneRN {

   private final PhoneDAO phoneDAO;

   public PhoneRN() {
      this.phoneDAO = DAOFactory.createPhoneDAO();
   }

   public void save(Phone phone) {
      this.phoneDAO.save(phone);
   }

   public void update(Phone phone) {
      this.phoneDAO.update(phone);
   }

   public void delete(Phone phone) {
      this.phoneDAO.delete(phone);
   }

   public List<Phone> listAll() {
      return this.phoneDAO.listAll();
   }

   public Phone findById(int id) {
      return this.phoneDAO.findById(id);
   }

}
