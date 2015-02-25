package com.magmaphonebook.util;

import com.magmaphonebook.model.phone.PhoneDAO;
import com.magmaphonebook.model.phone.PhoneDAOHibernate;
import com.magmaphonebook.model.user.UserDAO;
import com.magmaphonebook.model.user.UserDAOHibernate;

/**
 *
 * @author Dirceu Junior
 */
public class DAOFactory {

   public static UserDAO criarUsuarioDAO() {
      UserDAOHibernate usuarioDAO = new UserDAOHibernate();
      usuarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
      return usuarioDAO;
   }

   public static PhoneDAO criarContatoDAO() {
      PhoneDAOHibernate contatoDAO = new PhoneDAOHibernate();
      contatoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
      return contatoDAO;
   }

}
