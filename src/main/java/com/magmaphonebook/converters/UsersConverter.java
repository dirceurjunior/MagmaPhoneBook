package com.magmaphonebook.converters;

import com.magmaphonebook.model.users.Users;
import com.magmaphonebook.model.users.UsersRN;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "usersConverter")
public class UsersConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        UsersRN pRN = new UsersRN();
        Users users = pRN.findByName(string);
        return users;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Users users = new Users();
        users = (Users) o;
        return users.getName();
    }

}
