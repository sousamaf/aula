package br.catolica.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="livro_revisao")
public class LivroRevisao implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1178591281065219875L;
	private long idLivroRevisao;
	private Pessoa pessoa;
	private Livro livro;
	private int qtd;
	private Date dataRevisao;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_livro_revisao")
	public long getIdLivroRevisao() {
		return idLivroRevisao;
	}
	public void setIdLivroRevisao(long idLivroRevisao) {
		this.idLivroRevisao = idLivroRevisao;
	}
	@ManyToOne
	@JoinColumn(name="id_pessoa")
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	@ManyToOne
	@JoinColumn(name="id_livro")
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public int getQtd() {
		return qtd;
	}
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	
	@Column(name="data_revisao", updatable=false)
	@Temporal(TemporalType.DATE)
	public Date getDataRevisao() {
		return dataRevisao;
	}
	public void setDataRevisao(Date dataRevisao) {
		this.dataRevisao = dataRevisao;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dataRevisao == null) ? 0 : dataRevisao.hashCode());
		result = prime * result
				+ (int) (idLivroRevisao ^ (idLivroRevisao >>> 32));
		result = prime * result + ((livro == null) ? 0 : livro.hashCode());
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		result = prime * result + qtd;
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
		LivroRevisao other = (LivroRevisao) obj;
		if (dataRevisao == null) {
			if (other.dataRevisao != null)
				return false;
		} else if (!dataRevisao.equals(other.dataRevisao))
			return false;
		if (idLivroRevisao != other.idLivroRevisao)
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
		if (qtd != other.qtd)
			return false;
		return true;
	}

}
