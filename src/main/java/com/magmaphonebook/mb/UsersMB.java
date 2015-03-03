package com.magmaphonebook.mb;

import com.magmaphonebook.model.users.Users;
import com.magmaphonebook.model.users.UsersRN;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Dirceu Junior
 */
@ManagedBean
@ViewScoped
public class UsersMB implements Serializable {

    private static final long serialVersionUID = 1L;

    private Users users;

    private List<Users> listAll;
    private List<Users> listByName;

    private String page;

    private List<Users> listUsers = new ArrayList<>();

    public UsersMB() {
        this.page = "login";
        this.users = new Users();
    }

    public String inserir() {
        UsersRN uRN = new UsersRN();
        if (this.users.getId() != null && this.users.getId() != 0) {
            prepararUsers();
            uRN.update(getUsers());
            FacesMessage msg = new FacesMessage("ATUALIZADO COM SUCESSO!!!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            prepararUsers();
            uRN.save(getUsers());
            Set<String> permissoes = this.users.getPermissions();
            permissoes.add("ROLE_USER");
            FacesMessage msg = new FacesMessage("CADASTRADO COM SUCESSO!!!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        newUser();
        return getPage();
    }

    public void atualizaRelacionamentos() {
        UsersRN uRN = new UsersRN();
        prepararUsers();
        uRN.update(getUsers());
        FacesMessage msg = new FacesMessage("ATUALIZADO COM SUCESSO!!!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void prepararUsers() {
        users.setActive(true);
    }

    public void excluir() {
        UsersRN uRN = new UsersRN();
        if (this.users.getId() != null && this.users.getId() != 0) {
            uRN.delete(getUsers());
            FacesMessage msg = new FacesMessage("EXCLUIDO COM SUCESSO!!!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            FacesMessage msg = new FacesMessage("FAVOR SELECIONAR PARA EXCLUSÃO!!!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        newUser();
    }

    public String newUser() {
        this.users = new Users();
        return getPage();
    }

    public void limparListas() {
        this.listUsers.clear();

    }

    public void editar() {
        UsersRN uRN = new UsersRN();
        users = uRN.load(users.getId());
    }

    public List<Users> getListarTodos() {
        UsersRN uRN = new UsersRN();
        listAll = uRN.list();
        return listAll;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public List<Users> getListAll() {
        return listAll;
    }

    public void setListAll(List<Users> listAll) {
        this.listAll = listAll;
    }

    public List<Users> getListByName() {
        return listByName;
    }

    public void setListByName(List<Users> listByName) {
        this.listByName = listByName;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<Users> getListUsers() {
        return listUsers;
    }

    public void setListUsers(List<Users> listUsers) {
        this.listUsers = listUsers;
    }

}
