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

   public void salvar(Contact cliente) {
      this.contactDAO.salvar(cliente);
   }

   public void atualizar(Contact cliente) {
      this.contactDAO.atualizar(cliente);
   }

   public void excluir(Contact cliente) {
      this.contactDAO.excluir(cliente);
   }

   public List<Contact> listarTodos() {
      return this.contactDAO.listarTodos();
   }

   public List<Contact> listarPorNome(String nome) {
      return this.contactDAO.listarPorNome(nome);
   }

   public int buscaUltimoRegistro() {
      return this.contactDAO.retornaUltimoId();
   }

   public Contact porId(int id) {
      return this.contactDAO.porId(id);
   }

   public Contact porNome(String nome) {
      return this.contactDAO.porNome(nome);
   }

   public Contact porCPF(String cpf) {
      return this.contactDAO.porCPF(cpf);
   }

   public List<Contact> porNomeSimples(String nome) {
      return this.contactDAO.porNomeSimples(nome);
   }
}
