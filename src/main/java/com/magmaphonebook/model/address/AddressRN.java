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

   public void salvar(Address address) {
      this.addressDAO.salvar(address);
   }

   public void atualizar(Address address) {
      this.addressDAO.atualizar(address);
   }

   public void excluir(Address address) {
      this.addressDAO.excluir(address);
   }

   public List<Address> listarTodos() {
      return this.addressDAO.listarTodos();
   }

   public List<Address> listarPorNome(String nome) {
      return this.addressDAO.listarPorNome(nome);
   }

   public int buscaUltimoRegistro() {
      return this.addressDAO.retornaUltimoCodigo();
   }

   public Address porId(int id) {
      return this.addressDAO.porId(id);
   }

   public Address porNome(String nome) {
      return this.addressDAO.porNome(nome);
   }

}
