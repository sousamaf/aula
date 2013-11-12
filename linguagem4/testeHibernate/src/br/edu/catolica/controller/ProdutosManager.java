package br.edu.catolica.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;

import br.edu.catolica.tabelas.Produtos;
import br.edu.catolica.tabelas.ProdutosRn;

@ManagedBean
@ViewScoped
public class ProdutosManager {
	private ProdutosRn produtoRn = new ProdutosRn();
	private Produtos produto = new Produtos();
	List<Produtos> produtos = null;
	
	public String salvar()
	{
		produtoRn.salvar(produto);
		listar();
		return null;
	}
	public void submit(ActionEvent event) {  
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correct", "Correct");  
          
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    } 	
	public String listar()
	{
		produtos = produtoRn.listar();
		return null;
	}

	public ProdutosRn getProdutoRn() {
		return produtoRn;
	}

	public void setProdutoRn(ProdutosRn produtoRn) {
		this.produtoRn = produtoRn;
	}

	public Produtos getProduto() {
		return produto;
	}

	public void setProduto(Produtos produto) {
		this.produto = produto;
	}

	public List<Produtos> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produtos> produtos) {
		this.produtos = produtos;
	}
	
}