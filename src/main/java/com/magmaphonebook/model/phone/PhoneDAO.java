/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magmaphonebook.model.phone;

import java.util.List;

/**
 *
 * @author Dirceu Junior
 */
public interface PhoneDAO {

    public void salvar(Phone contato);

    public void atualizar(Phone contato);

    public void excluir(Phone contato);

    public Phone porId(Integer id);

    public List<Phone> listarTodos();

}
