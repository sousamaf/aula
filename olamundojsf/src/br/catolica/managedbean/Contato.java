package br.catolica.managedbean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Contato implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7566116543610565612L;
	private String nome;
	private String usuario;
	private String email;
	private String mensagem;
	
	
	public String getValidaUsuario()
	{
		if("".equals(usuario) || usuario == null)
		{
			return "";
		}
		else if(this.usuario.equals("marco"))
		{
			return "Que cara lindo";
		}
		else
		{
			return "";
		}
	}
	
	public String enviar()
	{
		
		return "agradecimento";
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
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
}