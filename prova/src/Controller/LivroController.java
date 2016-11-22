package Controller;
 

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.catolica.dao.LivroDAO;
import br.catolica.model.Livro;
 

@ManagedBean
@SessionScoped
public class LivroController {
 
private Livro livro;
@SuppressWarnings("rawtypes")
private DataModel listaLivros;

LivroDAO dao = new LivroDAO();

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DataModel getListarLivros() {
	List<Livro> lista = new LivroDAO().listar();
	listaLivros = new ListDataModel(lista);
	return listaLivros;
	}
	public Livro getLivro() {
	return livro;
	}
	public void setLivro(Livro livro) {
	this.livro = livro;
	}
	public String prepararAdicionarLivro(){
	livro = new Livro();
	return "conferir";
	}
	public String prepararAlterarLivro(){
	livro = (Livro)(listaLivros.getRowData());
	return "conferir";
	}
	public String excluirLivro(){
	Livro livroTemp = (Livro)(listaLivros.getRowData());
	dao.excluir(livroTemp);
	return "conferir";
	}
	public String adicionarLivro(){
	dao.atualizar(livro);
	return "confeirir";
	}
	public String alterarLivro(){
	dao.atualizar(livro);
	return "conferir";
	}
}