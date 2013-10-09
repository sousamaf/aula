package br.edu.catolica.tabelas;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Disciplina_rel_competencias implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4909131008237760547L;

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	@JoinColumn(name = "disciplina_id")
	private Disciplinas disciplina;

	@ManyToOne
	@JoinColumn(name = "competencia_id")
	private Competencias competencia;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Disciplinas getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplinas disciplina) {
		this.disciplina = disciplina;
	}

	public Competencias getCompetencia() {
		return competencia;
	}

	public void setCompetencia(Competencias competencia) {
		this.competencia = competencia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((competencia == null) ? 0 : competencia.hashCode());
		result = prime * result
				+ ((disciplina == null) ? 0 : disciplina.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Disciplina_rel_competencias other = (Disciplina_rel_competencias) obj;
		if (competencia == null) {
			if (other.competencia != null)
				return false;
		} else if (!competencia.equals(other.competencia))
			return false;
		if (disciplina == null) {
			if (other.disciplina != null)
				return false;
		} else if (!disciplina.equals(other.disciplina))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
