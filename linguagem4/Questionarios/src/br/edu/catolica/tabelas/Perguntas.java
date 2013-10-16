package br.edu.catolica.tabelas;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import com.sun.istack.internal.NotNull;

@Entity
public class Perguntas implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5921298667535849492L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idPergunta;
	@NotNull
	private String enunciado;
	private String keywords;
	public long getIdPergunta() {
		return idPergunta;
	}
	public void setIdPergunta(long idPergunta) {
		this.idPergunta = idPergunta;
	}
	public String getEnunciado() {
		return enunciado;
	}
	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((enunciado == null) ? 0 : enunciado.hashCode());
		result = prime * result + (int) (idPergunta ^ (idPergunta >>> 32));
		result = prime * result
				+ ((keywords == null) ? 0 : keywords.hashCode());
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
		Perguntas other = (Perguntas) obj;
		if (enunciado == null) {
			if (other.enunciado != null)
				return false;
		} else if (!enunciado.equals(other.enunciado))
			return false;
		if (idPergunta != other.idPergunta)
			return false;
		if (keywords == null) {
			if (other.keywords != null)
				return false;
		} else if (!keywords.equals(other.keywords))
			return false;
		return true;
	}
	
	
}
