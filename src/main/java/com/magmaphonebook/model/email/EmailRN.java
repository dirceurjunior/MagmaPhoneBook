/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magmaphonebook.model.email;

import com.magmaphonebook.util.DAOFactory;
import java.util.List;

/**
 *
 * @author Dirceu Junior
 */
public class EmailRN {

    private final EmailDAO emailDAO;

    public EmailRN() {
        this.emailDAO = DAOFactory.createEmailDAO();
    }

    public void save(Email email) {
        this.emailDAO.save(email);
    }

    public void update(Email email) {
        this.emailDAO.update(email);
    }

    public void delete(Email email) {
        this.emailDAO.delete(email);
    }

    public Email findById(int id) {
        return this.emailDAO.findById(id);
    }

    public List<Email> listAll() {
        return this.emailDAO.listAll();
    }

}
