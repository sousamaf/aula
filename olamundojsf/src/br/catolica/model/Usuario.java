package br.catolica.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Usuario implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8676754938154108511L;
	
	private long id_usuario;
	private Usuario_tipo_autenticacao id_usuario_tipo_autenticacao;
	private String nome;
	private String email;
	private String senha;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getId_usuario() {
		return id_usuario;
	}
	
	public void setId_usuario(long id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	public String getNome() {
		return nome;
	}

	@ManyToOne
	@JoinColumn(name="id_usuario_tipo_autenticacao")
	public Usuario_tipo_autenticacao getId_usuario_tipo_autenticacao() {
		return id_usuario_tipo_autenticacao;
	}

	public void setId_usuario_tipo_autenticacao(Usuario_tipo_autenticacao fk_id_usuario_tipo_autenticacao) {
		this.id_usuario_tipo_autenticacao = fk_id_usuario_tipo_autenticacao;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime
				* result
				+ ((id_usuario_tipo_autenticacao == null) ? 0
						: id_usuario_tipo_autenticacao.hashCode());
		result = prime * result + (int) (id_usuario ^ (id_usuario >>> 32));
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
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
		Usuario other = (Usuario) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id_usuario_tipo_autenticacao == null) {
			if (other.id_usuario_tipo_autenticacao != null)
				return false;
		} else if (!id_usuario_tipo_autenticacao
				.equals(other.id_usuario_tipo_autenticacao))
			return false;
		if (id_usuario != other.id_usuario)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}

}
