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

    public void save(Contact contact);

    public void update(Contact contact);

    public void delete(Contact contact);
    
    public Contact findById(Integer id);
    
    public Contact findByName (String name);

    public List<Contact> listAll();

    public List<Contact> listByName(String name);
    
    public Integer getLastId();
    
    public Contact findByCPF(String cpf);
    
    public List<Contact> findByNameSimple(String name);
    
}
