package com.magmaphonebook.model.user;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class UserDAOHibernate implements UserDAO {

    private Session session;

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void salvar(User usuario) {
        this.session.save(usuario);
    }

    @Override
    public void atualizar(User usuario) {
        if (usuario.getPermissao() == null || usuario.getPermissao().size() == 0) {
            User usuarioPermissao = this.carregar(usuario.getId());
            usuario.setPermissao(usuarioPermissao.getPermissao());
            this.session.evict(usuarioPermissao);
        }
        this.session.update(usuario);
    }

    @Override
    public void excluir(User usuario) {
        this.session.delete(usuario);
    }

    @Override
    public User carregar(Integer codigo) {
        //TODO o hibernate nao conseguira fazer a carga caso seja passado o User
        // no parametro, tem que ser diretamente a chave (integer)
        return (User) this.session.get(User.class, codigo);
    }

    @Override
    public User buscarPorLogin(String login) {
        String hql = "select u from Usuario u where u.login = :login";
        Query consulta = this.session.createQuery(hql);
        consulta.setString("login", login);

        //TODO mostrar primeiramente com o list e depois apresentar o uniqueResult
        return (User) consulta.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> listar() {
        return this.session.createCriteria(User.class).list();
    }

   @Override
   public User buscarPorEmail(String email) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }
}
