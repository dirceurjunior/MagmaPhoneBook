/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magmaphonebook.model.contact;

import com.magmaphonebook.model.address.Address;
import com.magmaphonebook.model.email.Email;
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
   private String nome;

   private String cpf;

   @Temporal(javax.persistence.TemporalType.DATE)
   private Date dataNascimento;

   @Temporal(javax.persistence.TemporalType.DATE)
   private Date dataCadastro;

   private String sexo;

   private String estadoCivil;

   private String etnia;

   private String profissao;

   private String prontuario;

   private String matricula;

   private String religiao;

   private String indicacao;

   private String nacionalidade;

   private String naturalidade;

   @Column(length = 250)
   private String observacoes;

   private Integer ativo;

   //////////////////////////////////////// MAPEAMENTO COM ENDEREÇOS
   @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   @JoinTable(
           name = "contact_address",
           joinColumns = @JoinColumn(name = "paciente_id"),
           inverseJoinColumns = @JoinColumn(name = "endereco_id"))
   private List<Address> address;

   //////////////////////////////////////// MAPEAMENTO COM CONTATOS
   @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   @JoinTable(
           name = "contact_phone",
           joinColumns = @JoinColumn(name = "paciente_id"),
           inverseJoinColumns = @JoinColumn(name = "contato_id"))
   private List<Contact> contatos;

   //////////////////////////////////////// MAPEAMENTO COM EMAILS
   @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   @JoinTable(name = "contact_email",
           joinColumns = @JoinColumn(name = "paciente_id"),
           inverseJoinColumns = @JoinColumn(name = "email_id"))
   private List<Email> emails;

}
