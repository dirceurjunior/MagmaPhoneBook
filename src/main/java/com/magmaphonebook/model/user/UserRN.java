package com.magmaphonebook.model.user;

import com.magmaphonebook.util.DAOFactory;
import java.util.List;

public class UserRN {

   private UserDAO userDAO;

   public UserRN() {
      this.userDAO = DAOFactory.createUserDAO();
   }

   public User carregar(Integer id) {
      return this.userDAO.load(id);
   }

   public User buscarPorLogin(String login) {
      return this.userDAO.findByLogin(login);
   }

   public void salvar(User user) {

      Integer id = user.getId();
      if (id == null || id == 0) {

         //user.getPermissao().add("ROLE_USUARIO");
         this.userDAO.save(user);

      } else {
         this.userDAO.update(user);
      }
   }

   public void excluir(User user) {
      this.userDAO.delete(user);
   }

   public List<User> listar() {
      return this.userDAO.list();
   }

}
