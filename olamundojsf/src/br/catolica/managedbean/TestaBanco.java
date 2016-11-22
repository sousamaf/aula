package br.catolica.managedbean;

import java.util.List;

import br.catolica.model.Usuario;
import br.catolica.model.Usuario_tipo_autenticacao;
import br.catolica.rn.UsuarioRN;

public class TestaBanco {

	public static void main(String[] args)
	{

		// Cria objeto do tipo usuario para salvar em banco.
		Usuario usuario = new Usuario();

		// Cria objeto de RN
		UsuarioRN usuarioRN = new UsuarioRN();


		Usuario_tipo_autenticacao autenticacao = new Usuario_tipo_autenticacao();
		//autenticacao.setId_usuario_tipo_autenticacao(3);
		autenticacao.setId_usuario_tipo_autenticacao(2);
		autenticacao.setAutenticacao("Facebook");
		
		
		// Atribui valores ao objeto usuario.
		usuario.setNome("nome3");
		usuario.setEmail("email3");
		usuario.setSenha("senha3");
		usuario.setId_usuario_tipo_autenticacao(autenticacao);
		
		// salva o usuario no banco.
		usuarioRN.salvar(usuario);

	
/*
		// Atualiza cadastro
		usuario.setId_usuario(4);
		usuario.setNome("nome");
		usuario.setEmail("balinha");
		usuario.setSenha("segura");
		
		usuarioRN.atualizar(usuario);
*/
		
/*
		// tenta excluir o id 2;
		usuario = new Usuario();
		usuario.setId_usuario(5);
		usuarioRN.excluir(usuario);
*/

		// Cria uma lista de usuarios para armazenamento memoria dos dados oriundos do banco.
		List<Usuario> users = null;
		
		// Busca todos os usuario do Banco.
		users = usuarioRN.listar();

		// Percorre a lista imprimindo em tela.
		if(users.size() > 0)
		{
			for(Usuario user1 : users)
			{
				System.out.println("Nome: " + user1.getNome());
				System.out.println("Email: " + user1.getEmail());
				System.out.println("Senha: " + user1.getSenha());
				System.out.println(" ");
			}
		}

		
/*
		// Busca usuarios do banco com a ocorrencia de 'mar' no inicio do nome
		users = usuarioRN.listar("nome", "mar%");

		// Percorre a lista imprimindo em tela.
		if(users.size() > 0)
		{
			for(Usuario user1 : users)
			{
				System.out.println("Nome: " + user1.getNome());
				System.out.println("Email: " + user1.getEmail());
				System.out.println("Senha: " + user1.getSenha());
				System.out.println(" ");
			}
		}
*/
	
	}

}
