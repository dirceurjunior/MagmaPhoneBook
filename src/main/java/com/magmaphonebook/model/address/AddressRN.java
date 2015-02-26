/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magmaphonebook.model.address;

import com.magmaphonebook.util.DAOFactory;
import java.util.List;

/**
 *
 * @author Dirceu Junior
 */
public class AddressRN {

   private final AddressDAO addressDAO;

   public AddressRN() {
      this.addressDAO = DAOFactory.createAddressDAO();
   }

   public void save(Address address) {
      this.addressDAO.save(address);
   }

   public void update(Address address) {
      this.addressDAO.update(address);
   }

   public void delete(Address address) {
      this.addressDAO.delete(address);
   }

   public List<Address> listAll() {
      return this.addressDAO.listAll();
   }

   public List<Address> listByName(String name) {
      return this.addressDAO.listByName(name);
   }

   public int getLastRecord() {
      return this.addressDAO.getLastRecord();
   }

   public Address findById(int id) {
      return this.addressDAO.findById(id);
   }

   public Address findByName(String name) {
      return this.addressDAO.findByName(name);
   }

}
