/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magmaphonebook.model.address;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Dirceu Junior
 */
@Entity
public class Address implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;

   private String typeAddress;

   private String typeStreet;

   private String street;

   private String number;

   private String neighbourhood;

   private String zipCode;

   private Integer state;

   private Integer city;

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getTypeAddress() {
      return typeAddress;
   }

   public void setTypeAddress(String typeAddress) {
      this.typeAddress = typeAddress;
   }

   public String getTypeStreet() {
      return typeStreet;
   }

   public void setTypeStreet(String typeStreet) {
      this.typeStreet = typeStreet;
   }

   public String getStreet() {
      return street;
   }

   public void setStreet(String street) {
      this.street = street;
   }

   public String getNumber() {
      return number;
   }

   public void setNumber(String number) {
      this.number = number;
   }

   public String getNeighbourhood() {
      return neighbourhood;
   }

   public void setNeighbourhood(String neighbourhood) {
      this.neighbourhood = neighbourhood;
   }

   public String getZipCode() {
      return zipCode;
   }

   public void setZipCode(String zipCode) {
      this.zipCode = zipCode;
   }

   public Integer getState() {
      return state;
   }

   public void setState(Integer state) {
      this.state = state;
   }

   public Integer getCity() {
      return city;
   }

   public void setCity(Integer city) {
      this.city = city;
   }

}
