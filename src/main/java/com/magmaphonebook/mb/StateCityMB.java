/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magmaphonebook.mb;

import com.magmaphonebook.model.stateCity.City;
import com.magmaphonebook.model.stateCity.State;
import com.magmaphonebook.model.stateCity.StateCityRN;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ValueChangeEvent;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Dirceu Junior
 */
@ManagedBean
@ViewScoped
public class StateCityMB {

   private City city;
   private State state;
   private List<City> listCities;
   private List<State> listStates;
   private boolean control = false;

   public StateCityMB() {
      city = new City();
      state = new State();
   }

   public void updateCities(ValueChangeEvent event) {
      int value = Integer.parseInt(event.getNewValue().toString());
      if (value != 0) {
         control = true;
         listCities = null;
         StateCityRN scRN = new StateCityRN();
         listCities = scRN.findByUF(Integer.parseInt(event.getNewValue().toString()));
      }
   }

   public City getCity() {
      return city;
   }

   public void setCity(City city) {
      this.city = city;
   }

   public State getState() {
      return state;
   }

   public void setState(State state) {
      this.state = state;
   }

   public List<City> getListCities() {
      return listCities;
   }

   public void setListCities(List<City> listCities) {
      this.listCities = listCities;
   }

   public List<State> getListStates() {
      StateCityRN scRN = new StateCityRN();
      listStates = scRN.listStates();
      return listStates;
   }

   public void setListStates(List<State> listStates) {
      this.listStates = listStates;
   }

   public boolean isControl() {
      return control;
   }

   public void setControl(boolean control) {
      this.control = control;
   }

}
