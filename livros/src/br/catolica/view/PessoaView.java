package br.catolica.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import br.catolica.managerbean.PessoaBean;
import br.catolica.model.Pessoa;

@ManagedBean
public class PessoaView {
	private List<Pessoa> pessoas;
	
	@ManagedProperty("#{pessoaBean}")
	private PessoaBean servico;
	
	@PostConstruct
    public void init() {
		pessoas = servico.createPessoa();
	}

	public List<Pessoa> getPessoa() {
		return pessoas;
	}

	public void setPessoa(List<Pessoa> pessoa) {
		this.pessoas = pessoa;
	}

	public PessoaBean getServico() {
		return servico;
	}

	public void setServico(PessoaBean servico) {
		this.servico = servico;
	}
	
	
	
}
