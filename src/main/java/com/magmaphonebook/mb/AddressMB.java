/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magmaphonebook.mb;

import com.magmaphonebook.model.address.Address;
import com.magmaphonebook.model.address.AddressRN;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Dirceu Junior
 */
@ManagedBean
@ViewScoped
public class AddressMB implements Serializable {

   private static final long serialVersionUID = 1L;

   private Address selecionado;
   private Address address = new Address();
   private List<Address> listarTodos;
   private List<Address> listarPorNome;
   private String pagina;

   public AddressMB() {
      this.pagina = "addresss";
      address = new Address();
   }

   public String inserir() {
      AddressRN eRN = new AddressRN();
      if (this.address.getId() != null && this.address.getId() != 0) {
         eRN.atualizar(getAddress());
         FacesMessage msg = new FacesMessage("PACIENTE ATUALIZADO COM SUCESSO!!!");
         FacesContext.getCurrentInstance().addMessage(null, msg);
      } else {
         eRN.salvar(getAddress());
         FacesMessage msg = new FacesMessage("PACIENTE CADASTRADO COM SUCESSO!!!");
         FacesContext.getCurrentInstance().addMessage(null, msg);
      }
      return pagina;
   }

   public String excluir() {
      AddressRN eRN = new AddressRN();
      if (this.address.getId() != null && this.address.getId() != 0) {
         eRN.excluir(getAddress());
         FacesMessage msg = new FacesMessage("PACIENTE EXCLUIDO COM SUCESSO!!!");
         FacesContext.getCurrentInstance().addMessage(null, msg);
      } else {
         FacesMessage msg = new FacesMessage("FAVOR SELECIONAR PACIENTE PARA EXCLUSÃO!!!");
         FacesContext.getCurrentInstance().addMessage(null, msg);
      }
      return pagina;
   }

   public String editar() {
      AddressRN eRN = new AddressRN();
      address = eRN.porId(address.getId());
      return pagina;
   }

   public String novo() {
      this.address = new Address();
      return pagina;
   }

   public Address getAddress() {
      return address;
   }

   public void setAddress(Address address) {
      this.address = address;
   }

   public List<Address> getListarTodos() {
      AddressRN eRN = new AddressRN();
      listarTodos = eRN.listarTodos();
      return listarTodos;
   }

   public void setListarTodos(List<Address> listar) {
      this.listarTodos = listar;
   }

   public List<Address> getListarPorNome() {
      AddressRN eRN = new AddressRN();
      listarPorNome = eRN.listarPorNome(address.getLogradouro());
      return listarPorNome;
   }

   public void setListarPorNome(List<Address> listarPorNome) {
      this.listarPorNome = listarPorNome;
   }

   public String getPagina() {
      return pagina;
   }

   public void setPagina(String pagina) {
      this.pagina = pagina;
   }

   public List<Address> completaNome(String query) {
      AddressRN eRN = new AddressRN();
      this.addresss = eRN.listarTodos();
      List<Address> sugestoes = new ArrayList<Address>();
      for (Address j : this.addresss) {
         if (j.getLogradouro().startsWith(query)) {
            sugestoes.add(j);
         }
      }
      return sugestoes;
   }

}
