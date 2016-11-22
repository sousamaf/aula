package br.catolica.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="filtro")
public class Filtro implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7611400191324838316L;
	private Long idFiltro;
	private Pessoa pessoa;
	private Livro livro;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_filtro")
	public Long getIdFiltro() {
		return idFiltro;
	}
	public void setIdFiltro(Long idFiltro) {
		this.idFiltro = idFiltro;
	}
	
	@OneToOne(targetEntity=Pessoa.class)
	@JoinColumn(name="id_pessoa", referencedColumnName="id_pessoa")
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	@OneToOne(targetEntity=Livro.class)
	@JoinColumn(name="id_livro", referencedColumnName="id_livro")
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idFiltro == null) ? 0 : idFiltro.hashCode());
		result = prime * result + ((livro == null) ? 0 : livro.hashCode());
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
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
		Filtro other = (Filtro) obj;
		if (idFiltro == null) {
			if (other.idFiltro != null)
				return false;
		} else if (!idFiltro.equals(other.idFiltro))
			return false;
		if (livro == null) {
			if (other.livro != null)
				return false;
		} else if (!livro.equals(other.livro))
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		return true;
	}
}
