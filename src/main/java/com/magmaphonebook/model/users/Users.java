package com.magmaphonebook.model.users;

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

/**
 *
 * @author DirceuRozolem
 */
@Entity
public class Users implements Serializable {

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue
   private Integer id;

   private String name;

   private String cpf;

   @NaturalId
   private String login;

   private String password;

   @Temporal(javax.persistence.TemporalType.TIMESTAMP)
   private Date dateBirth;

   @Temporal(javax.persistence.TemporalType.TIMESTAMP)
   private Date dateRegistration;

   private boolean active;

   @ElementCollection(targetClass = String.class)
   @JoinTable(
           name = "users_permissions",
           uniqueConstraints = {
              @UniqueConstraint(columnNames = {"users", "permissions"})},
           joinColumns = @JoinColumn(name = "users"))
   @Column(name = "permissions", length = 50)
   private Set<String> permissions = new HashSet<>();

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

   public String getLogin() {
      return login;
   }

   public void setLogin(String login) {
      this.login = login;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public Date getDateBirth() {
      return dateBirth;
   }

   public void setDateBirth(Date dateBirth) {
      this.dateBirth = dateBirth;
   }

   public Date getDateRegistration() {
      return dateRegistration;
   }

   public void setDateRegistration(Date dateRegistration) {
      this.dateRegistration = dateRegistration;
   }

   public boolean isActive() {
      return active;
   }

   public void setActive(boolean active) {
      this.active = active;
   }

   public Set<String> getPermissions() {
      return permissions;
   }

   public void setPermissions(Set<String> permissions) {
      this.permissions = permissions;
   }

}
