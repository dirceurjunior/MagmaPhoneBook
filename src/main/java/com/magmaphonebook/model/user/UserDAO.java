package com.magmaphonebook.model.user;

import java.util.List;

public interface UserDAO {

    public void salvar(User usuario);

    public void atualizar(User usuario);

    public void excluir(User usuario);

    public User carregar(Integer codigo);

    public User buscarPorLogin(String login);
    
    public User buscarPorEmail(String email);

    public List<User> listar();
}
