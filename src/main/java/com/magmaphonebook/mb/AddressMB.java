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

   private Address address;

   private Address selected;

   private List<Address> listAll;

   private List<Address> listByName;

   private String page;

   public AddressMB() {
      this.page = "address";
      address = new Address();
   }

   public String inserir() {
      AddressRN eRN = new AddressRN();
      if (this.address.getId() != null && this.address.getId() != 0) {
         eRN.update(getAddress());
         FacesMessage msg = new FacesMessage("ATUALIZADO COM SUCESSO!!!");
         FacesContext.getCurrentInstance().addMessage(null, msg);
      } else {
         eRN.save(getAddress());
         FacesMessage msg = new FacesMessage("CADASTRADO COM SUCESSO!!!");
         FacesContext.getCurrentInstance().addMessage(null, msg);
      }
      return page;
   }

   public String excluir() {
      AddressRN eRN = new AddressRN();
      if (this.address.getId() != null && this.address.getId() != 0) {
         eRN.delete(getAddress());
         FacesMessage msg = new FacesMessage("EXCLUIDO COM SUCESSO!!!");
         FacesContext.getCurrentInstance().addMessage(null, msg);
      } else {
         FacesMessage msg = new FacesMessage("FAVOR SELECIONAR PARA EXCLUSÃO!!!");
         FacesContext.getCurrentInstance().addMessage(null, msg);
      }
      return page;
   }

   public String editar() {
      AddressRN eRN = new AddressRN();
      address = eRN.findById(address.getId());
      return page;
   }

   public String novo() {
      this.address = new Address();
      return page;
   }

   public List<Address> getListAll() {
      AddressRN eRN = new AddressRN();
      listAll = eRN.listAll();
      return listAll;
   }

   public void setListAll(List<Address> listAll) {
      this.listAll = listAll;
   }

   public List<Address> getListByName() {
      AddressRN eRN = new AddressRN();
      listByName = eRN.listByName(address.getStreet());
      return listByName;
   }

   public void setListByName(List<Address> listByName) {
      this.listByName = listByName;
   }

   public List<Address> completeName(String query) {
      AddressRN eRN = new AddressRN();
      this.listAll = eRN.listAll();
      List<Address> results = new ArrayList<Address>();
      for (Address j : this.listAll) {
         if (j.getStreet().startsWith(query)) {
            results.add(j);
         }
      }
      return results;
   }

   public Address getAddress() {
      return address;
   }

   public void setAddress(Address address) {
      this.address = address;
   }

   public Address getSelected() {
      return selected;
   }

   public void setSelected(Address selected) {
      this.selected = selected;
   }

   public String getPage() {
      return page;
   }

   public void setPage(String page) {
      this.page = page;
   }

}
