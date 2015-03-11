/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magmaphonebook.model.contact;

import com.magmaphonebook.model.address.Address;
import com.magmaphonebook.model.email.Email;
import com.magmaphonebook.model.phone.Phone;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 *
 * @author Dirceu Junior
 */
@Entity
@SQLDelete(sql = "update Contact set ativo = 0 where id = ?")
@Where(clause = "ativo = 1")
public class Contact implements Serializable {

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;

   @Column(length = 50)
   private String name;

   private String cpf;

   @Temporal(javax.persistence.TemporalType.DATE)
   private Date dateRegistration;

   private String gender;

   @Column(length = 250)
   private String note;

   private Integer active;

   //////////////////////////////////////// MAPEAMENTO COM ENDEREÇOS
   @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   @JoinTable(
           name = "contact_address",
           joinColumns = @JoinColumn(name = "contact_id"),
           inverseJoinColumns = @JoinColumn(name = "address_id"))
   private List<Address> address;

   //////////////////////////////////////// MAPEAMENTO COM CONTATOS
   @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   @JoinTable(
           name = "contact_phones",
           joinColumns = @JoinColumn(name = "contact_id"),
           inverseJoinColumns = @JoinColumn(name = "phone_id"))
   private List<Phone> phones;

   //////////////////////////////////////// MAPEAMENTO COM EMAILS
   @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   @JoinTable(name = "contact_emails",
           joinColumns = @JoinColumn(name = "contact_id"),
           inverseJoinColumns = @JoinColumn(name = "email_id"))
   private List<Email> emails;

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getCpf() {
      return cpf;
   }

   public void setCpf(String cpf) {
      this.cpf = cpf;
   }

   public Date getDateRegistration() {
      return dateRegistration;
   }

   public void setDateRegistration(Date dateRegistration) {
      this.dateRegistration = dateRegistration;
   }

   public String getGender() {
      return gender;
   }

   public void setGender(String gender) {
      this.gender = gender;
   }

   public String getNote() {
      return note;
   }

   public void setNote(String note) {
      this.note = note;
   }

   public Integer getActive() {
      return active;
   }

   public void setActive(Integer active) {
      this.active = active;
   }

   public List<Address> getAddress() {
      return address;
   }

   public void setAddress(List<Address> address) {
      this.address = address;
   }

   public List<Phone> getPhones() {
      return phones;
   }

   public void setPhones(List<Phone> phones) {
      this.phones = phones;
   }

   public List<Email> getEmails() {
      return emails;
   }

   public void setEmails(List<Email> emails) {
      this.emails = emails;
   }
   
   

}
