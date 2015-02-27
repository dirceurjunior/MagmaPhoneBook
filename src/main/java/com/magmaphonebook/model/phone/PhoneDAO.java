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

    public void save(Phone phone);

    public void update(Phone phone);

    public void delete(Phone phone);

    public Phone findById(Integer id);

    public List<Phone> listAll();

}
