package br.catolica.view;


import br.catolica.managerbean.LivroBean;
import br.catolica.model.Livro;


import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;



@ManagedBean
public class DataView implements Serializable {
    
	private static final long serialVersionUID = 1L;

	private List<Livro> livr;
         
    @ManagedProperty("#{LivroBean}")
    private LivroBean livros;
     
    @PostConstruct
    public void init() {
        livr = livros.createLivro();
    }
 
    public List<Livro> getLivro() {
        return livr;
    }
 
    public void setService(LivroBean livros) {
        this.livros = livros;
    }
    
}