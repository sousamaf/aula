package br.catolica.rn;

import java.util.List;

import br.catolica.dao.LivroDAO;
import br.catolica.model.Livro;

public class LivroRN {
	
	LivroDAO livroDao = new LivroDAO();
	
	public void salvar(Livro livro)
	{
		livroDao.salvar(livro);
	}
	
	public void atualizar(Livro livro)
	{
		livroDao.atualizar(livro);
	}
	
	public void excluir(Livro livro)
	{

		Livro l =  livroDao.getLivro(livro.getIdLivro());
		if(l != null)
		{
			livroDao.excluir(livro);
		} else
		{
			System.out.println("Registro inexistente.");
		}
	}
	
	public List<Livro> listar()
	{
		return livroDao.listar();
	}
	
	public List<Livro> listar(String campo, String valor)
	{
		return livroDao.listar(campo, valor);
	}
}
