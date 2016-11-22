package br.catolica.rn;

import java.util.List;

import br.catolica.dao.UsuarioDAO;
import br.catolica.model.Usuario;

public class UsuarioRN {
	
	UsuarioDAO usuarioDao = new UsuarioDAO();
	
	public void salvar(Usuario usuario)
	{
		usuarioDao.salvar(usuario);
	}
	
	public void atualizar(Usuario usuario)
	{
		usuarioDao.atualizar(usuario);
	}
	
	public void excluir(Usuario usuario)
	{
		Usuario u = usuarioDao.getUsuario(usuario.getId_usuario());
		if(u != null)
		{
			usuarioDao.excluir(usuario);
		} else
		{
			System.out.println("Registro inexistente.");
		}
	}
	
	public List<Usuario> listar()
	{
		return usuarioDao.listar();
	}
	
	public List<Usuario> listar(String campo, String valor)
	{
		return usuarioDao.listar(campo, valor);
	}
}
