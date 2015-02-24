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
public class PacienteRN {

   private final PessoaDAO pacienteDAO;

   public PacienteRN() {
      this.pacienteDAO = DAOFactory.criarPacienteDAO();
   }

   public void salvar(Pessoa cliente) {
      this.pacienteDAO.salvar(cliente);
   }

   public void atualizar(Pessoa cliente) {
      this.pacienteDAO.atualizar(cliente);
   }

   public void excluir(Pessoa cliente) {
      this.pacienteDAO.excluir(cliente);
   }

   public List<Pessoa> listarTodos() {
      return this.pacienteDAO.listarTodos();
   }

   public List<Pessoa> listarPorNome(String nome) {
      return this.pacienteDAO.listarPorNome(nome);
   }

   public int buscaUltimoRegistro() {
      return this.pacienteDAO.retornaUltimoId();
   }

   public Pessoa porId(int id) {
      return this.pacienteDAO.porId(id);
   }

   public Pessoa porNome(String nome) {
      return this.pacienteDAO.porNome(nome);
   }

   public Pessoa porCPF(String cpf) {
      return this.pacienteDAO.porCPF(cpf);
   }

   public List<Pessoa> porNomeSimples(String nome) {
      return this.pacienteDAO.porNomeSimples(nome);
   }
}
