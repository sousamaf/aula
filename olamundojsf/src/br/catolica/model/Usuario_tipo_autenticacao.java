package br.catolica.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Usuario_tipo_autenticacao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2981351292292522934L;
	
	private long id_usuario_tipo_autenticacao;
	private String autenticacao;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getId_usuario_tipo_autenticacao() {
		return id_usuario_tipo_autenticacao;
	}
	public void setId_usuario_tipo_autenticacao(long id_usuario_tipo_autenticacao) {
		this.id_usuario_tipo_autenticacao = id_usuario_tipo_autenticacao;
	}
	
	public String getAutenticacao() {
		return autenticacao;
	}
	public void setAutenticacao(String autenticacao) {
		this.autenticacao = autenticacao;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((autenticacao == null) ? 0 : autenticacao.hashCode());
		result = prime
				* result
				+ (int) (id_usuario_tipo_autenticacao ^ (id_usuario_tipo_autenticacao >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario_tipo_autenticacao other = (Usuario_tipo_autenticacao) obj;
		if (autenticacao == null) {
			if (other.autenticacao != null)
				return false;
		} else if (!autenticacao.equals(other.autenticacao))
			return false;
		if (id_usuario_tipo_autenticacao != other.id_usuario_tipo_autenticacao)
			return false;
		return true;
	}
}
