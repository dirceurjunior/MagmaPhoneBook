   /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magmaphonebook.model.contact;

import java.util.List;

/**
 *
 * @author Dirceu Junior
 */
public interface ContactDAO {

    public void salvar(Contact cliente);

    public void atualizar(Contact cliente);

    public void excluir(Contact cliente);
    
    public Contact porId(Integer id);
    
    public Contact porNome (String nome);

    public List<Contact> listarTodos();

    public List<Contact> listarPorNome(String nome);
    
    public Integer retornaUltimoId();
    
    public Contact porCPF(String cpf);
    
    public List<Contact> porNomeSimples(String nome);
    
}
