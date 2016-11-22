package br.catolica.model;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ManagedBean
@Entity
@Table(name="livro")
public class Livro implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7024205833116775771L;
	
	private Long idLivro;
	private String referencia;
	private int publicacao;
	private String classificacao;
	private int qtd;
	private Unidade unidade;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_livro")
	public Long getIdLivro() {
		return idLivro;
	}
	public void setIdLivro(Long id_livro) {
		this.idLivro = id_livro;
	}
	@Column(name="referencia")
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	@Column(name="publicacao")
	public int getPublicacao() {
		return publicacao;
	}
	public void setPublicacao(int publicacao) {
		this.publicacao = publicacao;
	}
	@Column(name="classificacao")
	public String getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}
	@Column(name="qtd")
	public int getQtd() {
		return qtd;
	}
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	@Column(name="Unidade")
	@Enumerated(EnumType.STRING)
	public Unidade getUnidade() {
		return unidade;
	}
	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((classificacao == null) ? 0 : classificacao.hashCode());
		result = prime * result
				+ ((idLivro == null) ? 0 : idLivro.hashCode());
		result = prime * result + publicacao;
		result = prime * result + qtd;
		result = prime * result
				+ ((referencia == null) ? 0 : referencia.hashCode());
		result = prime * result + ((unidade == null) ? 0 : unidade.hashCode());
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
		Livro other = (Livro) obj;
		if (classificacao == null) {
			if (other.classificacao != null)
				return false;
		} else if (!classificacao.equals(other.classificacao))
			return false;
		if (idLivro == null) {
			if (other.idLivro != null)
				return false;
		} else if (!idLivro.equals(other.idLivro))
			return false;
		if (publicacao != other.publicacao)
			return false;
		if (qtd != other.qtd)
			return false;
		if (referencia == null) {
			if (other.referencia != null)
				return false;
		} else if (!referencia.equals(other.referencia))
			return false;
		if (unidade != other.unidade)
			return false;
		return true;
	}
}
