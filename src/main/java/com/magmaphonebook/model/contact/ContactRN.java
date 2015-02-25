/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magmaphonebook.model.contact;

import br.com.magmadoctor.util.DAOFactory;
import java.util.List;

/**
 *
 * @author Dirceu Junior
 */
public class ContactRN {

   private final ContactDAO pacienteDAO;

   public ContactRN() {
      this.pacienteDAO = DAOFactory.criarPacienteDAO();
   }

   public void salvar(Contact cliente) {
      this.pacienteDAO.salvar(cliente);
   }

   public void atualizar(Contact cliente) {
      this.pacienteDAO.atualizar(cliente);
   }

   public void excluir(Contact cliente) {
      this.pacienteDAO.excluir(cliente);
   }

   public List<Contact> listarTodos() {
      return this.pacienteDAO.listarTodos();
   }

   public List<Contact> listarPorNome(String nome) {
      return this.pacienteDAO.listarPorNome(nome);
   }

   public int buscaUltimoRegistro() {
      return this.pacienteDAO.retornaUltimoId();
   }

   public Contact porId(int id) {
      return this.pacienteDAO.porId(id);
   }

   public Contact porNome(String nome) {
      return this.pacienteDAO.porNome(nome);
   }

   public Contact porCPF(String cpf) {
      return this.pacienteDAO.porCPF(cpf);
   }

   public List<Contact> porNomeSimples(String nome) {
      return this.pacienteDAO.porNomeSimples(nome);
   }
}
