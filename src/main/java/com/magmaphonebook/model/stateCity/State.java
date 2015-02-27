/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magmaphonebook.model.stateCity;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.NaturalId;

/**
 *
 * @author Dirceu Junior
 */
@Entity
public class State implements Serializable {

    @Id
    private Integer id;
    @NaturalId
    private String name;
    private String acronym;
    private Integer ibge;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public Integer getIbge() {
        return ibge;
    }

    public void setIbge(Integer ibge) {
        this.ibge = ibge;
    }

}
