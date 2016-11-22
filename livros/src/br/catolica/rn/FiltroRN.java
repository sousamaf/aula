package br.catolica.rn;

import java.util.List;

import br.catolica.dao.FiltroDAO;
import br.catolica.model.Filtro;

public class FiltroRN {
	
	FiltroDAO filtroDao = new FiltroDAO();
	
	public void salvar(Filtro filtro)
	{
		filtroDao.salvar(filtro);
	}
	
	public void atualizar(Filtro filtro)
	{
		filtroDao.atualizar(filtro);
	}
	
	public void excluir(Filtro filtro)
	{

		Filtro f =  filtroDao.getFiltro(filtro.getIdFiltro());
		if(f != null)
		{
			filtroDao.excluir(filtro);
		} else
		{
			System.out.println("Registro inexistente.");
		}
	}
	
	public List<Filtro> listar()
	{
		return filtroDao.listar();
	}

	public List<Filtro> listarNaoAvaliados(Long idPessoa)
	{
		return filtroDao.listarNaoAvaliados(idPessoa);
	}

	public List<Filtro> listarAvaliados(Long idPessoa)
	{
		return filtroDao.listarAvaliados(idPessoa);
	}

	public List<Filtro> listar(String campo, Long valor)
	{
		return filtroDao.listar(campo, valor);
	}
}
