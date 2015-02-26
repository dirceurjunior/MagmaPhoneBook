package com.magmaphonebook.mb;

import com.magmaphonebook.model.address.Address;
import com.magmaphonebook.model.address.AddressRN;
import com.magmaphonebook.model.contact.Contact;
import com.magmaphonebook.model.contact.ContactRN;
import com.magmaphonebook.model.email.Email;
import com.magmaphonebook.model.email.EmailRN;
import com.magmaphonebook.model.phone.Phone;
import com.magmaphonebook.model.phone.PhoneRN;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.event.SelectEvent;

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

   public String inserir() {
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
      novo();
      return getPage();
   }

   public void atualizaRelacionamentos() {
      ContactRN cRN = new ContactRN();
      prepararContact();
      cRN.update(getContact());
      FacesMessage msg = new FacesMessage("PACIENTE ATUALIZADO COM SUCESSO!!!");
      FacesContext.getCurrentInstance().addMessage(null, msg);
   }

   public void prepararContact() {
      contact.setAddress(listAddress);
      contact.setPhones(listPhones);
      contact.setEmails(listEmails);
      contact.setAtivo(1);

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
      novo();
   }

   public String novo() {
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
   public void novoEmail() {
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
      novoEmail();
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
      novoEmail();
   }
    //-------------------------------------------------------------------------------------------------------

   //--------------------------------------------------------------- bloco referente aos phones 
   public void novoPhone() {
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
      novoPhone();
   }

   public void removePhone() {
      PhoneRN cRN = new PhoneRN();
      Phone phoneRemovido;
      if (this.contact.getId() != null && this.contact.getId() != 0) {
         phones.remove(phone);
         phoneRemovido = phone;
         atualizaRelacionamentos();
         cRN.delete(phoneRemovido);
      } else {
         phones.remove(phone);
         cRN.delete(phone);
      }
      novoPhone();
   }
    //-------------------------------------------------------------------------------------------------------

   //------------------------------------------------------------ bloco referente aos listAddress 
   public void novoAddress() {
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
      novoAddress();
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
      novoAddress();
   }
    //-------------------------------------------------------------------------------------------------------

   //--------------------------------------------------------------------------------------------
   public List<Contact> getListarTodos() {
      ContactRN cRN = new ContactRN();
      listarTodos = cRN.listarTodos();
      return listarTodos;
   }

   public List<Contact> getListarPorNome() {
      if ((contact.getNome() != null) && (!contact.getNome().equals(""))) {
         ContactRN cRN = new ContactRN();
         listarPorNome = cRN.listarPorNome(contact.getNome());
      } else {
         listarPorNome = null;
      }
      return listarPorNome;
   }

   public List<Contact> getListarPorNomeSimples() {
      if ((contact.getNome() != null) && (!contact.getNome().equals(""))) {
         ContactRN cRN = new ContactRN();
         listarPorNome = cRN.porNomeSimples(contact.getNome());
      } else {
         listarPorNome = null;
      }
      return listarPorNome;
   }

   public List<Contact> completaNome(String query) {
      ContactRN cRN = new ContactRN();
      this.contacts = cRN.listarTodos();
      List<Contact> sugestoes = new ArrayList<>();
      for (Contact j : this.contacts) {
         if (j.getNome().startsWith(query)) {
            sugestoes.add(j);
         }
      }
      return sugestoes;
   }

   public void adicionaConvenio(ValueChangeEvent event) {
      int valor = Integer.parseInt(event.getNewValue().toString());
      boolean controle = true;
      for (Iterator iterator = convenios.iterator(); iterator.hasNext();) {
         Convenio c = (Convenio) iterator.next();
         if (c.getId() == valor) {
            controle = false;
         }
      }
      if (valor == 0) {
      } else if ((controle)) {
         ConvenioRN cRN = new ConvenioRN();
         convenios.add(cRN.porId(Integer.parseInt(event.getNewValue().toString())));
      } else {
         FacesMessage msg = new FacesMessage("CONVÊNIO JÁ SELECIONADO!!!");
         FacesContext.getCurrentInstance().addMessage(null, msg);
      }
   }

   public void removeConvenio() {
      convenios.remove(convenio);
      convenio = new Convenio();
   }

   public void conveniosPorContact(SelectEvent event) {
      convenios.clear();
      contact = (Contact) event.getObject();
      convenios.addAll(contact.getConvenios());
   }

   public void exportarPDF(ActionEvent actionEvent) throws JRException, IOException {
      File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/relatorios/Contact.jasper"));
      JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), null, new JRBeanCollectionDataSource(this.getContacts()));

      HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
      response.addHeader("Content-disposition", "attachment; filename=jsfReporte.pdf");
      ServletOutputStream stream = response.getOutputStream();

      JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
      stream.flush();
      stream.close();

      FacesContext.getCurrentInstance().responseComplete();
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

   public List<Contact> getContacts() {
      return contacts;
   }

   public void setContacts(List<Contact> contacts) {
      this.contacts = contacts;
   }

   public List<Address> getAddresss() {
      return listAddress;
   }

   public void setAddresss(List<Address> listAddress) {
      this.listAddress = listAddress;
   }

   public List<Phone> getPhones() {
      return phones;
   }

   public void setPhones(List<Phone> phones) {
      this.phones = phones;
   }

   public List<Email> getEmails() {
      return listEmails;
   }

   public void setEmails(List<Email> listEmails) {
      this.listEmails = listEmails;
   }

}