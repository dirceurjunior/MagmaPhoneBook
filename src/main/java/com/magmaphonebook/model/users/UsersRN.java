package com.magmaphonebook.model.users;

import com.magmaphonebook.util.DAOFactory;
import java.util.List;

public class UsersRN {

   private final UsersDAO usersDAO;

   public UsersRN() {
      this.usersDAO = DAOFactory.createUserDAO();
   }

   public Users load(Integer id) {
      return this.usersDAO.load(id);
   }

   public Users findByLogin(String login) {
      return this.usersDAO.findByLogin(login);
   }

   public void save(Users user) {

      Integer id = user.getId();
      if (id == null || id == 0) {

         //user.getPermissao().add("ROLE_USUARIO");
         this.usersDAO.save(user);

      } else {
         this.usersDAO.update(user);
      }
   }

   public void delete(Users user) {
      this.usersDAO.delete(user);
   }

   public List<Users> list() {
      return this.usersDAO.list();
   }

    public void update(Users users) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Users findByName(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Users findByCPF(String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
