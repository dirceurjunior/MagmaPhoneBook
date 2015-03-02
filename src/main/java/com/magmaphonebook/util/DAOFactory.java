package com.magmaphonebook.util;

import com.magmaphonebook.model.address.AddressDAO;
import com.magmaphonebook.model.address.AddressDAOHibernate;
import com.magmaphonebook.model.contact.ContactDAO;
import com.magmaphonebook.model.contact.ContactDAOHibernate;
import com.magmaphonebook.model.email.EmailDAO;
import com.magmaphonebook.model.email.EmailDAOHibernate;
import com.magmaphonebook.model.phone.PhoneDAO;
import com.magmaphonebook.model.phone.PhoneDAOHibernate;
import com.magmaphonebook.model.stateCity.StateCityDAO;
import com.magmaphonebook.model.stateCity.StateCityDAOHibernate;
import com.magmaphonebook.model.users.UsersDAO;
import com.magmaphonebook.model.users.UsersDAOHibernate;

/**
 *
 * @author Dirceu Junior
 */
public class DAOFactory {

   public static UsersDAO createUserDAO() {
      UsersDAOHibernate userDAO = new UsersDAOHibernate();
      userDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
      return userDAO;
   }

   public static ContactDAO createContactDAO() {
      ContactDAOHibernate contactDAO = new ContactDAOHibernate();
      contactDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
      return contactDAO;
   }

   public static PhoneDAO createPhoneDAO() {
      PhoneDAOHibernate phoneDAO = new PhoneDAOHibernate();
      phoneDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
      return phoneDAO;
   }

   public static AddressDAO createAddressDAO() {
      AddressDAOHibernate addressDAO = new AddressDAOHibernate();
      addressDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
      return addressDAO;
   }

   public static StateCityDAO createStateCityDAO() {
      StateCityDAOHibernate stateCityDAO = new StateCityDAOHibernate();
      stateCityDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
      return stateCityDAO;
   }

   public static EmailDAO createEmailDAO() {
      EmailDAOHibernate emailDAO = new EmailDAOHibernate();
      emailDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
      return emailDAO;
   }

}
