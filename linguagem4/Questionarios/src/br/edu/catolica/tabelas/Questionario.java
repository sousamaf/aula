package br.edu.catolica.tabelas;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Questionario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9108879389542902908L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idQuestionario;
	
	@ManyToMany
	@JoinTable(name="questionario_rel_perguntas", 
			joinColumns=@JoinColumn(name="idQuestionario"),
			inverseJoinColumns=@JoinColumn(name="idPerguntas"))	
	private Collection<Perguntas> perguntas;
	
	@ManyToOne
	@JoinColumn(name="idEvento")
	private Eventos evento;
	private int ordem;
	public long getIdQuestionario() {
		return idQuestionario;
	}
	public void setIdQuestionario(long idQuestionario) {
		this.idQuestionario = idQuestionario;
	}
	public Collection<Perguntas> getPerguntas() {
		return perguntas;
	}
	public void setPerguntas(Collection<Perguntas> perguntas) {
		this.perguntas = perguntas;
	}
	public Eventos getEvento() {
		return evento;
	}
	public void setEvento(Eventos evento) {
		this.evento = evento;
	}
	public int getOrdem() {
		return ordem;
	}
	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((evento == null) ? 0 : evento.hashCode());
		result = prime * result
				+ (int) (idQuestionario ^ (idQuestionario >>> 32));
		result = prime * result + ordem;
		result = prime * result
				+ ((perguntas == null) ? 0 : perguntas.hashCode());
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
		Questionario other = (Questionario) obj;
		if (evento == null) {
			if (other.evento != null)
				return false;
		} else if (!evento.equals(other.evento))
			return false;
		if (idQuestionario != other.idQuestionario)
			return false;
		if (ordem != other.ordem)
			return false;
		if (perguntas == null) {
			if (other.perguntas != null)
				return false;
		} else if (!perguntas.equals(other.perguntas))
			return false;
		return true;
	}
	
	
}
