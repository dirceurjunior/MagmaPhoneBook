package com.magmaphonebook.model.user;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class UserDAOHibernate implements UserDAO {

   private Session session;

   public void setSession(Session session) {
      this.session = session;
   }

   @Override
   public void save(User user) {
      this.session.save(user);
   }

   @Override
   public void update(User user) {
      if (user.getPermission() == null || user.getPermission().size() == 0) {
         User userPermission = this.load(user.getId());
         user.setPermission(userPermission.getPermission());
         this.session.evict(userPermission);
      }
      this.session.update(user);
   }

   @Override
   public void delete(User user) {
      this.session.delete(user);
   }

   @Override
   public User load(Integer id) {
      //TODO o hibernate nao conseguira fazer a carga caso seja passado o User
      // no parametro, tem que ser diretamente a chave (integer)
      return (User) this.session.get(User.class, id);
   }

   @Override
   public User findByLogin(String login) {
      String hql = "select u from User u where u.login = :login";
      Query consult = this.session.createQuery(hql);
      consult.setString("login", login);

      //TODO mostrar primeiramente com o list e depois apresentar o uniqueResult
      return (User) consult.uniqueResult();
   }

   @SuppressWarnings("unchecked")
   @Override
   public List<User> list() {
      return this.session.createCriteria(User.class).list();
   }

   @Override
   public User findByEmail(String email) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }
}
