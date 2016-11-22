package br.catolica.managerbean;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import br.catolica.model.Pessoa;
import br.catolica.rn.PessoaRN;

@ManagedBean(name="pessoaBean")
@ApplicationScoped
public class PessoaBean {
	
	public List<Pessoa> createPessoa() {
		PessoaRN pessoaRN = new PessoaRN();
		return pessoaRN.listar();
	}
	
}
