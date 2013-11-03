package br.edu.catolica.tabelas;

import java.util.List;

public class ProdutosRn {
	ProdutosDao produtosDao = new ProdutosDao();
	public void salvar(Produtos produto)
	{
		produtosDao.salvar(produto);
	}
	public List<Produtos> listar()
	{
		return produtosDao.listar();
	}
}
