package com.magmaphonebook.model.users;

import com.magmaphonebook.util.DAOFactory;
import java.util.List;

public class UsersRN {

   private UsersDAO userDAO;

   public UsersRN() {
      this.userDAO = DAOFactory.createUserDAO();
   }

   public Users carregar(Integer id) {
      return this.userDAO.load(id);
   }

   public Users buscarPorLogin(String login) {
      return this.userDAO.findByLogin(login);
   }

   public void salvar(Users user) {

      Integer id = user.getId();
      if (id == null || id == 0) {

         //user.getPermissao().add("ROLE_USUARIO");
         this.userDAO.save(user);

      } else {
         this.userDAO.update(user);
      }
   }

   public void excluir(Users user) {
      this.userDAO.delete(user);
   }

   public List<Users> listar() {
      return this.userDAO.list();
   }

}
