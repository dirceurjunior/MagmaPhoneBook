package com.magmaphonebook.mb;

import com.magmaphonebook.model.address.Address;
import com.magmaphonebook.model.address.AddressRN;
import com.magmaphonebook.model.contact.Contact;
import com.magmaphonebook.model.contact.ContactRN;
import com.magmaphonebook.model.email.Email;
import com.magmaphonebook.model.email.EmailRN;
import com.magmaphonebook.model.phone.Phone;
import com.magmaphonebook.model.phone.PhoneRN;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
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
public class ContactMB implements Serializable {

   private static final long serialVersionUID = 1L;

   private Contact contact;
   private Address address;
   private Phone phone;
   private Email email;

   private List<Contact> listAll;
   private List<Contact> listByName;

   private String page;

   private List<Contact> listContacts = new ArrayList<>();
   private List<Address> listAddress = new ArrayList<>();
   private List<Phone> listPhones = new ArrayList<>();
   private List<Email> listEmails = new ArrayList<>();

   public ContactMB() {
      this.page = "contact";
      this.contact = new Contact();
      this.address = new Address();
      this.phone = new Phone();
      this.email = new Email();
   }

   public String save() {
      ContactRN cRN = new ContactRN();
      if (this.contact.getId() != null && this.contact.getId() != 0) {
         prepararContact();
         cRN.update(getContact());
         FacesMessage msg = new FacesMessage("ATUALIZADO COM SUCESSO!!!");
         FacesContext.getCurrentInstance().addMessage(null, msg);
      } else {
         prepararContact();
         cRN.save(getContact());
         FacesMessage msg = new FacesMessage("CADASTRADO COM SUCESSO!!!");
         FacesContext.getCurrentInstance().addMessage(null, msg);
      }
      newContact();
      return getPage();
   }

   public void atualizaRelacionamentos() {
      ContactRN cRN = new ContactRN();
      prepararContact();
      cRN.update(getContact());
      FacesMessage msg = new FacesMessage("ATUALIZADO COM SUCESSO!!!");
      FacesContext.getCurrentInstance().addMessage(null, msg);
   }

   public void prepararContact() {
      contact.setAddress(listAddress);
      contact.setPhones(listPhones);
      contact.setEmails(listEmails);
      contact.setActive(1);

   }

   public void delete() {
      ContactRN cRN = new ContactRN();
      if (this.contact.getId() != null && this.contact.getId() != 0) {
         cRN.delete(getContact());
         FacesMessage msg = new FacesMessage("PACIENTE EXCLUIDO COM SUCESSO!!!");
         FacesContext.getCurrentInstance().addMessage(null, msg);
      } else {
         FacesMessage msg = new FacesMessage("FAVOR SELECIONAR PACIENTE PARA EXCLUSÃO!!!");
         FacesContext.getCurrentInstance().addMessage(null, msg);
      }
      newContact();
   }

   public String newContact() {
      this.contact = new Contact();
      this.address = new Address();
      this.phone = new Phone();
      this.email = new Email();
      return getPage();
   }

   public void limparListas() {
      this.listContacts.clear();
      this.listPhones.clear();
      this.listAddress.clear();
      this.listEmails.clear();
   }

   public void editar() {
      ContactRN cRN = new ContactRN();
      contact = cRN.findById(contact.getId());
      listPhones = contact.getPhones();
      listAddress = contact.getAddress();
      listEmails = contact.getEmails();

   }

   //--------------------------------------------------------------- bloco referente aos listEmails 
   public void newEmail() {
      email = new Email();
   }

   public void addEmail() {
      EmailRN eRN = new EmailRN();
      if (email.getId() == null) {
         eRN.save(email);
         listEmails.add(email);
      } else {
         for (Iterator iterator = listEmails.iterator(); iterator.hasNext();) {
            Email e = (Email) iterator.next();
            if (Objects.equals(e.getId(), email.getId())) {
               listEmails.set(listEmails.indexOf(e), email);
               eRN.update(email);
            }
         }
      }
      newEmail();
   }

   public void removeEmail() {
      EmailRN eRN = new EmailRN();
      Email emailRemovido;
      if (this.contact.getId() != null && this.contact.getId() != 0) {
         listEmails.remove(email);
         emailRemovido = email;
         atualizaRelacionamentos();
         eRN.delete(emailRemovido);
      } else {
         listEmails.remove(email);
         eRN.delete(email);
      }
      newEmail();
   }
    //-------------------------------------------------------------------------------------------------------

   //--------------------------------------------------------------- bloco referente aos phones 
   public void newPhone() {
      phone = new Phone();
   }

   public void addPhone() {
      PhoneRN cRN = new PhoneRN();
      if (phone.getId() == null) {
         cRN.save(phone);
         listPhones.add(phone);
      } else {
         for (Iterator iterator = listPhones.iterator(); iterator.hasNext();) {
            Phone c = (Phone) iterator.next();
            if (Objects.equals(c.getId(), phone.getId())) {
               listPhones.set(listPhones.indexOf(c), phone);
               cRN.update(phone);
            }
         }
      }
      newPhone();
   }

   public void removePhone() {
      PhoneRN cRN = new PhoneRN();
      Phone phoneRemovido;
      if (this.contact.getId() != null && this.contact.getId() != 0) {
         listPhones.remove(phone);
         phoneRemovido = phone;
         atualizaRelacionamentos();
         cRN.delete(phoneRemovido);
      } else {
         listPhones.remove(phone);
         cRN.delete(phone);
      }
      newPhone();
   }
    //-------------------------------------------------------------------------------------------------------

   //------------------------------------------------------------ bloco referente aos listAddress 
   public void newAddress() {
      address = new Address();
   }

   public void addAddress() {
      AddressRN eRN = new AddressRN();
      if (address.getId() == null) {
         eRN.save(address);
         listAddress.add(address);
      } else {
         for (Iterator iterator = listAddress.iterator(); iterator.hasNext();) {
            Address e = (Address) iterator.next();
            if (Objects.equals(e.getId(), address.getId())) {
               listAddress.set(listAddress.indexOf(e), address);
               eRN.update(address);
            }
         }
      }
      newAddress();
   }

   public void removeAddress() {
      AddressRN eRN = new AddressRN();
      Address addressRemovido;
      if (this.contact.getId() != null && this.contact.getId() != 0) {
         listAddress.remove(address);
         addressRemovido = address;
         atualizaRelacionamentos();
         eRN.delete(addressRemovido);
      } else {
         listAddress.remove(address);
         eRN.delete(address);
      }
      newAddress();
   }
    //-------------------------------------------------------------------------------------------------------

   //--------------------------------------------------------------------------------------------
   public List<Contact> getListAll() {
      ContactRN cRN = new ContactRN();
      listAll = cRN.listAll();
      return listAll;
   }

   public List<Contact> getListByName() {
      if ((contact.getName() != null) && (!contact.getName().equals(""))) {
         ContactRN cRN = new ContactRN();
         listByName = cRN.listByName(contact.getName());
      } else {
         listByName = null;
      }
      return listByName;
   }

   public List<Contact> getListByNameSimple() {
      if ((contact.getName() != null) && (!contact.getName().equals(""))) {
         ContactRN cRN = new ContactRN();
         listByName = cRN.findByNameSimple(contact.getName());
      } else {
         listByName = null;
      }
      return listByName;
   }

   public List<Contact> completeName(String query) {
      ContactRN cRN = new ContactRN();
      this.listContacts = cRN.listAll();
      List<Contact> results = new ArrayList<>();
      for (Contact c : this.listContacts) {
         if (c.getName().startsWith(query)) {
            results.add(c);
         }
      }
      return results;
   }

   public Contact getContact() {
      return contact;
   }

   public void setContact(Contact contact) {
      this.contact = contact;
   }

   public Address getAddress() {
      return address;
   }

   public void setAddress(Address address) {
      this.address = address;
   }

   public Phone getPhone() {
      return phone;
   }

   public void setPhone(Phone phone) {
      this.phone = phone;
   }

   public Email getEmail() {
      return email;
   }

   public void setEmail(Email email) {
      this.email = email;
   }

   public String getPage() {
      return page;
   }

   public void setPage(String page) {
      this.page = page;
   }

   public List<Contact> getListContacts() {
      return listContacts;
   }

   public void setListContacts(List<Contact> listContacts) {
      this.listContacts = listContacts;
   }

   public List<Address> getListAddress() {
      return listAddress;
   }

   public void setListAddress(List<Address> listAddress) {
      this.listAddress = listAddress;
   }

   public List<Phone> getListPhones() {
      return listPhones;
   }

   public void setListPhones(List<Phone> listPhones) {
      this.listPhones = listPhones;
   }

   public List<Email> getListEmails() {
      return listEmails;
   }

   public void setListEmails(List<Email> listEmails) {
      this.listEmails = listEmails;
   }

}
