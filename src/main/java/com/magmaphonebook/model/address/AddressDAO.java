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

    public void save(Address address);

    public void update(Address address);

    public void delete(Address address);

    public Address findById(Integer id);

    public Address findByName(String name);

    public List<Address> listAll();

    public List<Address> listByName(String name);

    public Integer retornaUltimoCodigo();

}
