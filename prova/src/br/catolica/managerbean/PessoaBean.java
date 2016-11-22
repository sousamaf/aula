package br.catolica.managerbean;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import br.catolica.model.Pessoa;
import br.catolica.rn.PessoaRN;

@ManagedBean(name="pessoaBean")
@ApplicationScoped
public class PessoaBean {

	private String nome;
	private String senha;
	private String email;
	
	
	

	public List<Pessoa> createPessoa() {
		PessoaRN pessoaRN = new PessoaRN();
		return pessoaRN.listar();
	}
	
public String cadastrar(){
		
		Pessoa user = new Pessoa();
		PessoaRN usuario = new PessoaRN();
		
		user.setNome(nome);
		user.setEmail(email);
		user.setSenha(senha);
		
		usuario.salvar(user);
	
		return "confirmar";
	}
	


public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public String getSenha() {
	return senha;
}

public void setSenha(String senha) {
	this.senha = senha;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}
}
