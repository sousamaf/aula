package br.catolica.rn;

import java.util.List;

import br.catolica.dao.LivroRevisaoDAO;
import br.catolica.model.LivroRevisao;

public class LivroRevisaoRN {
	
	LivroRevisaoDAO livroRevisaoDao = new LivroRevisaoDAO();
	
	public void salvar(LivroRevisao livroRevisao)
	{
		livroRevisaoDao.salvar(livroRevisao);
	}
	
	public void atualizar(LivroRevisao livroRevisao)
	{
		livroRevisaoDao.atualizar(livroRevisao);
	}
	
	public void excluir(LivroRevisao livroRevisao)
	{

		LivroRevisao l =  livroRevisaoDao.getLivro(livroRevisao.getIdLivroRevisao());
		if(l != null)
		{
			livroRevisaoDao.excluir(livroRevisao);
		} else
		{
			System.out.println("Registro inexistente.");
		}
	}
	
	public List<LivroRevisao> listar()
	{
		return livroRevisaoDao.listar();
	}
	
	public List<LivroRevisao> listar(String campo, String valor)
	{
		return livroRevisaoDao.listar(campo, valor);
	}
}
