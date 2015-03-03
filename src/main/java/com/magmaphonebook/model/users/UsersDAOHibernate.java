package com.magmaphonebook.model.users;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class UsersDAOHibernate implements UsersDAO {

    private Session session;

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void save(Users user) {
        this.session.save(user);
    }

    @Override
    public void update(Users user) {
        if (user.getPermissions() == null || user.getPermissions().isEmpty()) {
            Users userPermission = this.load(user.getId());
            user.setPermissions(userPermission.getPermissions());
            this.session.evict(userPermission);
        }
        this.session.update(user);
    }

    @Override
    public void delete(Users user) {
        this.session.delete(user);
    }

    @Override
    public Users load(Integer id) {
      //TODO o hibernate nao conseguira fazer a carga caso seja passado o User
        // no parametro, tem que ser diretamente a chave (integer)
        return (Users) this.session.get(Users.class, id);
    }

    @Override
    public Users findByLogin(String login) {
        String hql = "select u from Users u where u.login = :login";
        Query consult = this.session.createQuery(hql);
        consult.setString("login", login);

        //TODO mostrar primeiramente com o list e depois apresentar o uniqueResult
        return (Users) consult.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Users> list() {
        return this.session.createCriteria(Users.class).list();
    }

    @Override
    public Users findByEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
