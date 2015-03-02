package com.magmaphonebook.model.users;

import java.util.List;

public interface UsersDAO {

   public void save(Users user);

   public void update(Users user);

   public void delete(Users user);

   public Users load(Integer id);

   public Users findByLogin(String login);

   public Users findByEmail(String email);

   public List<Users> list();
}
