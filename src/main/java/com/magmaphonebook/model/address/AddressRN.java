/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magmaphonebook.model.address;

import br.com.magmadoctor.util.DAOFactory;
import java.util.List;

/**
 *
 * @author Dirceu Junior
 */
public class AddressRN {

    private final AddressDAO enderecoDAO;

    public AddressRN() {
        this.enderecoDAO = DAOFactory.criarEnderecoDAO();
    }

    public void salvar(Address endereco) {
        this.enderecoDAO.salvar(endereco);
    }

    public void atualizar(Address endereco) {
        this.enderecoDAO.atualizar(endereco);
    }

    public void excluir(Address endereco) {
        this.enderecoDAO.excluir(endereco);
    }

    public List<Address> listarTodos() {
        return this.enderecoDAO.listarTodos();
    }

    public List<Address> listarPorNome(String nome) {
        return this.enderecoDAO.listarPorNome(nome);
    }

    public int buscaUltimoRegistro() {
        return this.enderecoDAO.retornaUltimoCodigo();
    }

    public Address porId(int id) {
        return this.enderecoDAO.porId(id);
    }

    public Address porNome(String nome) {
        return this.enderecoDAO.porNome(nome);
    }

}
