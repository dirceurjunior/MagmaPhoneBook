package br.com.magmaagenda.modelo.usuario;

import br.com.magmaagenda.util.DAOFactory;
import java.util.List;

public class UsuarioRN {

   private UsuarioDAO usuarioDAO;

   public UsuarioRN() {
      this.usuarioDAO = DAOFactory.criarUsuarioDAO();
   }

   public Usuario carregar(Integer id) {
      return this.usuarioDAO.carregar(id);
   }

   public Usuario buscarPorLogin(String login) {
      return this.usuarioDAO.buscarPorLogin(login);
   }

   public void salvar(Usuario usuario) {

      Integer id = usuario.getId();
      if (id == null || id == 0) {

         //usuario.getPermissao().add("ROLE_USUARIO");
         this.usuarioDAO.salvar(usuario);

      } else {
         this.usuarioDAO.atualizar(usuario);
      }
   }

   public void excluir(Usuario usuario) {
      this.usuarioDAO.excluir(usuario);
   }

   public List<Usuario> listar() {
      return this.usuarioDAO.listar();
   }
//	public void enviarEmailPosCadastramento(Usuario usuario) throws RNException {
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

   public Usuario porCPF(String cpf) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

   public Usuario porNome(String string) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

   public List<Usuario> listarTodos() {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

   public List<Usuario> listarPorNome(String nome) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

   public void atualizar(Usuario usuario) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

   public Usuario porId(Integer id) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

   public List<Usuario> porNomeSimples(String nome) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }
}
