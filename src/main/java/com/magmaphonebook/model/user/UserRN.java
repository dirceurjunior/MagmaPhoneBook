package com.magmaphonebook.model.user;

import com.magmaphonebook.util.DAOFactory;
import java.util.List;

public class UserRN {

   private UserDAO userDAO;

   public UserRN() {
      this.userDAO = DAOFactory.createUserDAO();
   }

   public User carregar(Integer id) {
      return this.userDAO.carregar(id);
   }

   public User buscarPorLogin(String login) {
      return this.userDAO.buscarPorLogin(login);
   }

   public void salvar(User user) {

      Integer id = user.getId();
      if (id == null || id == 0) {

         //user.getPermissao().add("ROLE_USUARIO");
         this.userDAO.salvar(user);

      } else {
         this.userDAO.atualizar(user);
      }
   }

   public void excluir(User user) {
      this.userDAO.excluir(user);
   }

   public List<User> listar() {
      return this.userDAO.listar();
   }
//	public void enviarEmailPosCadastramento(User user) throws RNException {
//		//Enviando um e-mail conforme o idioma do usu�rio
//		String[] info = user.getIdioma().split("_");
//		Locale locale = new Locale(info[0], info[1]);
//			
//		String titulo = MensagemUtil.getMensagem(locale, "email_titulo");
//		String mensagem = MensagemUtil.getMensagem(locale, "email_mensagem", user.getNome(), user.getLogin(), user.getSenha());
//		try {		
//			EmailUtil emailUtil = new EmailUtil();
//			emailUtil.enviarEmail(null, user.getEmail(), titulo, mensagem);
//		} catch (UtilException e) {
//			throw new RNException(e);
//		}
//	}

   public User porCPF(String cpf) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

   public User porNome(String string) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

   public List<User> listarTodos() {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

   public List<User> listarPorNome(String nome) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

   public void atualizar(User user) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

   public User porId(Integer id) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

   public List<User> porNomeSimples(String nome) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }
}
