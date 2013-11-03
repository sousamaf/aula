package br.edu.catolica.tabelas;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name = "disciplinas")
public class Disciplinas implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7073468612706397844L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "disciplina_id")
	private Integer disciplina_id;
	private String descricao;
	
	@OneToMany(mappedBy = "disciplinas_id", cascade = CascadeType.ALL)
	private Collection<Disciplina_rel_competencias> disciplinaRelCompetencias;

	public Integer getDisciplina_id() {
		return disciplina_id;
	}

	public void setDisciplina_id(Integer disciplina_id) {
		this.disciplina_id = disciplina_id;
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
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime
				* result
				+ ((disciplinaRelCompetencias == null) ? 0
						: disciplinaRelCompetencias.hashCode());
		result = prime * result
				+ ((disciplina_id == null) ? 0 : disciplina_id.hashCode());
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
		Disciplinas other = (Disciplinas) obj;
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
		if (disciplina_id == null) {
			if (other.disciplina_id != null)
				return false;
		} else if (!disciplina_id.equals(other.disciplina_id))
			return false;
		return true;
	}


}
