package br.edu.catolica;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class FormTest implements Serializable{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5024215045054478065L;
	private String nome;
	private String email;
	
	public String salvar()
	{
		// todo o processamento do metodo.
		
		return "home";
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
}
