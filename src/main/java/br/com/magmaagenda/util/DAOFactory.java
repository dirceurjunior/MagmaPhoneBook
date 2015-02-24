package br.com.magmaagenda.util;

import com.magmaphonebook.model.phone.PhoneDAO;
import com.magmaphonebook.model.phone.PhoneDAOHibernate;
import br.com.magmaagenda.modelo.usuario.UsuarioDAO;
import br.com.magmaagenda.modelo.usuario.UsuarioDAOHibernate;

/**
 *
 * @author Dirceu Junior
 */
public class DAOFactory {

   public static UsuarioDAO criarUsuarioDAO() {
      UsuarioDAOHibernate usuarioDAO = new UsuarioDAOHibernate();
      usuarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
      return usuarioDAO;
   }

   public static PhoneDAO criarContatoDAO() {
      PhoneDAOHibernate contatoDAO = new PhoneDAOHibernate();
      contatoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
      return contatoDAO;
   }

}
