package br.catolica.managerbean;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;





import br.catolica.model.Livro;
import br.catolica.rn.LivroRN;

@ManagedBean(name="livroBean")
@ApplicationScoped
public class LivroBean {
	
	public List<Livro> createLivro() {
		LivroRN livroRN = new LivroRN();
		return livroRN.listar();
	
}
}