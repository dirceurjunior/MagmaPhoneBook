package br.com.magmaagenda.util;

import br.com.magmaagenda.modelo.contato.ContatoDAO;
import br.com.magmaagenda.modelo.contato.ContatoDAOHibernate;
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

   public static ContatoDAO criarContatoDAO() {
      ContatoDAOHibernate contatoDAO = new ContatoDAOHibernate();
      contatoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
      return contatoDAO;
   }

}
