package br.catolica.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.catolica.managerbean.LivroRevisaoBean;
import br.catolica.model.LivroRevisao;

@ManagedBean(name="livroRevisaoView")
@ViewScoped
public class LivroRevisaoView implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -2327987633630961745L;

	private List<LivroRevisao> revisoes;
	
	@ManagedProperty("#{livroRevisaoBean}")
	private LivroRevisaoBean revisoesBean;

	
    @PostConstruct
    public void init() {
        revisoes = revisoesBean.createLivroRevisao();
        /*
        for (LivroRevisao livroRevisao : revisoes) {
			System.out.println(livroRevisao.getLivro());
		}
		*/
    }


	public List<LivroRevisao> getRevisoes() {
		return revisoes;
	}


	public void setRevisoes(List<LivroRevisao> revisoes) {
		this.revisoes = revisoes;
	}


	public LivroRevisaoBean getRevisoesBean() {
		return revisoesBean;
	}


	public void setRevisoesBean(LivroRevisaoBean revisoesBean) {
		this.revisoesBean = revisoesBean;
	}
}
