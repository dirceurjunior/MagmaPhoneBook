package com.magmaphonebook.model.user;

import com.magmaphonebook.util.DAOFactory;
import java.util.List;

public class UserRN {

   private UserDAO usuarioDAO;

   public UserRN() {
      this.usuarioDAO = DAOFactory.criarUsuarioDAO();
   }

   public User carregar(Integer id) {
      return this.usuarioDAO.carregar(id);
   }

   public User buscarPorLogin(String login) {
      return this.usuarioDAO.buscarPorLogin(login);
   }

   public void salvar(User usuario) {

      Integer id = usuario.getId();
      if (id == null || id == 0) {

         //usuario.getPermissao().add("ROLE_USUARIO");
         this.usuarioDAO.salvar(usuario);

      } else {
         this.usuarioDAO.atualizar(usuario);
      }
   }

   public void excluir(User usuario) {
      this.usuarioDAO.excluir(usuario);
   }

   public List<User> listar() {
      return this.usuarioDAO.listar();
   }
//	public void enviarEmailPosCadastramento(User usuario) throws RNException {
//		//Enviando um e-mail conforme o idioma do usu�rio
//		String[] info = usuario.getIdioma().split("_");
//		Locale locale = new Locale(info[0], info[1]);
//			
//		String titulo = MensagemUtil.getMensagem(locale, "email_titulo");
//		String mensagem = MensagemUtil.getMensagem(locale, "email_mensagem", usuario.getNome(), usuario.getLogin(), usuario.getSenha());
//		try {		
//			EmailUtil emailUtil = new EmailUtil();
//			emailUtil.enviarEmail(null, usuario.getEmail(), titulo, mensagem);
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

   public void atualizar(User usuario) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

   public User porId(Integer id) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

   public List<User> porNomeSimples(String nome) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }
}
