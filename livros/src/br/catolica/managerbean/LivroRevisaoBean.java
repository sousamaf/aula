package br.catolica.managerbean;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import br.catolica.model.LivroRevisao;
import br.catolica.rn.LivroRevisaoRN;

@ManagedBean(name="livroRevisaoBean")
@ApplicationScoped
public class LivroRevisaoBean {
	public List<LivroRevisao> createLivroRevisao() {
		LivroRevisaoRN livroRevisaoRN = new LivroRevisaoRN();
		return livroRevisaoRN.listar();
		
	}

}
