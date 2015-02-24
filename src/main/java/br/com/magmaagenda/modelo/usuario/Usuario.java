package br.com.magmaagenda.modelo.usuario;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Temporal;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.NaturalId;

@Entity
public class Usuario implements Serializable {

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue
   private Integer id;

   private String nome;

   private String cpf;

   private String endereco;

   private String nro;

   private String bairro;

   private Integer estado;

   private Integer municipio;

   private String foneFixo;

   private String foneCelular;

   private String email;

   @NaturalId
   private String login;

   private String senha;

   @Temporal(javax.persistence.TemporalType.TIMESTAMP)
   private Date dataNascimento;

   @Temporal(javax.persistence.TemporalType.TIMESTAMP)
   private Date dataCadastro;

   private boolean ativo;

   @ElementCollection(targetClass = String.class)
   @JoinTable(
           name = "usuario_permissao",
           uniqueConstraints = {
              @UniqueConstraint(columnNames = {"usuario", "permissao"})},
           joinColumns
           = @JoinColumn(name = "usuario"))
   @Column(name = "permissao", length = 50)
   private Set<String> permissao = new HashSet<>();

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

   public String getEndereco() {
      return endereco;
   }

   public void setEndereco(String endereco) {
      this.endereco = endereco;
   }

   public String getNro() {
      return nro;
   }

   public void setNro(String nro) {
      this.nro = nro;
   }

   public String getBairro() {
      return bairro;
   }

   public void setBairro(String bairro) {
      this.bairro = bairro;
   }

   public Integer getEstado() {
      return estado;
   }

   public void setEstado(Integer estado) {
      this.estado = estado;
   }

   public Integer getMunicipio() {
      return municipio;
   }

   public void setMunicipio(Integer municipio) {
      this.municipio = municipio;
   }

   public String getFoneFixo() {
      return foneFixo;
   }

   public void setFoneFixo(String foneFixo) {
      this.foneFixo = foneFixo;
   }

   public String getFoneCelular() {
      return foneCelular;
   }

   public void setFoneCelular(String foneCelular) {
      this.foneCelular = foneCelular;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getLogin() {
      return login;
   }

   public void setLogin(String login) {
      this.login = login;
   }

   public String getSenha() {
      return senha;
   }

   public void setSenha(String senha) {
      this.senha = senha;
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

   public boolean isAtivo() {
      return ativo;
   }

   public void setAtivo(boolean ativo) {
      this.ativo = ativo;
   }

   public Set<String> getPermissao() {
      return permissao;
   }

   public void setPermissao(Set<String> permissao) {
      this.permissao = permissao;
   }

}
