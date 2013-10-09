package br.edu.catolica.tabelas;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "competencias")
public class Competencias implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3434228508825760971L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Integer competencia_id;
	private String descricao;
	
	@OneToMany(mappedBy = "competencias_id", cascade = CascadeType.ALL)
	private Collection<Disciplina_rel_competencias> disciplinaRelCompetencias;

	public Integer getCompetencia_id() {
		return competencia_id;
	}

	public void setCompetencia_id(Integer competencia_id) {
		this.competencia_id = competencia_id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Collection<Disciplina_rel_competencias> getDisciplinaRelCompetencias() {
		return disciplinaRelCompetencias;
	}

	public void setDisciplinaRelCompetencias(
			Collection<Disciplina_rel_competencias> disciplinaRelCompetencias) {
		this.disciplinaRelCompetencias = disciplinaRelCompetencias;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((competencia_id == null) ? 0 : competencia_id.hashCode());
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime
				* result
				+ ((disciplinaRelCompetencias == null) ? 0
						: disciplinaRelCompetencias.hashCode());
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
		Competencias other = (Competencias) obj;
		if (competencia_id == null) {
			if (other.competencia_id != null)
				return false;
		} else if (!competencia_id.equals(other.competencia_id))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (disciplinaRelCompetencias == null) {
			if (other.disciplinaRelCompetencias != null)
				return false;
		} else if (!disciplinaRelCompetencias
				.equals(other.disciplinaRelCompetencias))
			return false;
		return true;
	}
	
}
