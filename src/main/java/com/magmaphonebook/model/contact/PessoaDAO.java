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
public interface PessoaDAO {

    public void salvar(Pessoa cliente);

    public void atualizar(Pessoa cliente);

    public void excluir(Pessoa cliente);
    
    public Pessoa porId(Integer id);
    
    public Pessoa porNome (String nome);

    public List<Pessoa> listarTodos();

    public List<Pessoa> listarPorNome(String nome);
    
    public Integer retornaUltimoId();
    
    public Pessoa porCPF(String cpf);
    
    public List<Pessoa> porNomeSimples(String nome);
    
}
