/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magmaphonebook.model.email;


import java.util.List;

/**
 *
 * @author Dirceu Junior
 */
public interface EmailDAO {

    public void save(Email email);

    public void update(Email email);

    public void delete(Email email);

    public Email findById(Integer id);

    public List<Email> listAll();

}
