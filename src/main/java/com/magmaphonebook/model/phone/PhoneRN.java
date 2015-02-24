/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magmaphonebook.model.phone;

import br.com.magmaagenda.util.DAOFactory;
import java.util.List;

/**
 *
 * @author Dirceu Junior
 */
public class PhoneRN {

   private final PhoneDAO contatoDAO;

   public PhoneRN() {
      this.contatoDAO = DAOFactory.criarContatoDAO();
   }

   public void salvar(Phone contato) {
      this.contatoDAO.salvar(contato);
   }

   public void atualizar(Phone contato) {
      this.contatoDAO.atualizar(contato);
   }

   public void excluir(Phone contato) {
      this.contatoDAO.excluir(contato);
   }

   public List<Phone> listarTodos() {
      return this.contatoDAO.listarTodos();
   }

   public Phone porId(int id) {
      return this.contatoDAO.porId(id);
   }

}
