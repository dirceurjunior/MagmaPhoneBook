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

   public String getNome() {
      return nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public String getCpf() {
      return cpf;
   }

   public void setCpf(String cpf) {
      this.cpf = cpf;
   }

   public Date getDataNascimento() {
      return dataNascimento;
   }

   public void setDataNascimento(Date dataNascimento) {
      this.dataNascimento = dataNascimento;
   }

   public Date getDataCadastro() {
      return dataCadastro;
   }

   public void setDataCadastro(Date dataCadastro) {
      this.dataCadastro = dataCadastro;
   }

   public String getSexo() {
      return sexo;
   }

   public void setSexo(String sexo) {
      this.sexo = sexo;
   }

   public String getEstadoCivil() {
      return estadoCivil;
   }

   public void setEstadoCivil(String estadoCivil) {
      this.estadoCivil = estadoCivil;
   }

   public String getEtnia() {
      return etnia;
   }

   public void setEtnia(String etnia) {
      this.etnia = etnia;
   }

   public String getProfissao() {
      return profissao;
   }

   public void setProfissao(String profissao) {
      this.profissao = profissao;
   }

   public String getProntuario() {
      return prontuario;
   }

   public void setProntuario(String prontuario) {
      this.prontuario = prontuario;
   }

   public String getMatricula() {
      return matricula;
   }

   public void setMatricula(String matricula) {
      this.matricula = matricula;
   }

   public String getReligiao() {
      return religiao;
   }

   public void setReligiao(String religiao) {
      this.religiao = religiao;
   }

   public String getIndicacao() {
      return indicacao;
   }

   public void setIndicacao(String indicacao) {
      this.indicacao = indicacao;
   }

   public String getNacionalidade() {
      return nacionalidade;
   }

   public void setNacionalidade(String nacionalidade) {
      this.nacionalidade = nacionalidade;
   }

   public String getNaturalidade() {
      return naturalidade;
   }

   public void setNaturalidade(String naturalidade) {
      this.naturalidade = naturalidade;
   }

   public String getObservacoes() {
      return observacoes;
   }

   public void setObservacoes(String observacoes) {
      this.observacoes = observacoes;
   }

   public Integer getAtivo() {
      return ativo;
   }

   public void setAtivo(Integer ativo) {
      this.ativo = ativo;
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
