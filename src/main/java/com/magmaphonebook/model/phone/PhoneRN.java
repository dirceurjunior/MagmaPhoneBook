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

   public void salvar(Phone phone) {
      this.phoneDAO.salvar(phone);
   }

   public void atualizar(Phone phone) {
      this.phoneDAO.atualizar(phone);
   }

   public void excluir(Phone phone) {
      this.phoneDAO.excluir(phone);
   }

   public List<Phone> listarTodos() {
      return this.phoneDAO.listarTodos();
   }

   public Phone porId(int id) {
      return this.phoneDAO.porId(id);
   }

}
