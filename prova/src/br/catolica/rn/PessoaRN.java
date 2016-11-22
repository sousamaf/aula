package br.catolica.rn;

import java.util.List;

import br.catolica.dao.PessoaDAO;
import br.catolica.model.Pessoa;

public class PessoaRN {
	
	PessoaDAO pessoaDao = new PessoaDAO();
	
	public void salvar(Pessoa pessoa)
	{
		pessoaDao.salvar(pessoa);
	}
	
	public void atualizar(Pessoa pessoa)
	{
		pessoaDao.atualizar(pessoa);
	}
	
	public void excluir(Pessoa pessoa)
	{

		Pessoa p =  pessoaDao.getPessoa(pessoa.getIdPessoa());
		if(p != null)
		{
			pessoaDao.excluir(pessoa);
		} else
		{
			System.out.println("Registro inexistente.");
		}
	}
	
	public List<Pessoa> listar()
	{
		return pessoaDao.listar();
	}
	
	public List<Pessoa> listar(String campo, String valor)
	{
		return pessoaDao.listar(campo, valor);
	}
	
	public Pessoa getPessoa(Long i)
	{
		return pessoaDao.getPessoa(i);
	}
}
