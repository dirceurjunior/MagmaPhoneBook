/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magmaphonebook.model.address;

import java.util.List;

/**
 *
 * @author Dirceu Junior
 */
public interface AddressDAO {

    public void salvar(Address endereco);

    public void atualizar(Address endereco);

    public void excluir(Address endereco);

    public Address porId(Integer id);

    public Address porNome(String nome);

    public List<Address> listarTodos();

    public List<Address> listarPorNome(String nome);

    public Integer retornaUltimoCodigo();

}
