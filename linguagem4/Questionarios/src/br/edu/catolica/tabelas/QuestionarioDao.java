package br.edu.catolica.tabelas;

import java.util.List;

import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import br.edu.catolica.conexao.HibernateUtil;

public class QuestionarioDao {
	private Session sessao;
	private Transaction transacao;

	public void salvar(Questionario questionario)
	{
		try{
			this.sessao = HibernateUtil.getSessionFactory().openSession();
			this.transacao = this.sessao.beginTransaction();
			this.sessao.save(questionario);
			this.transacao.commit();
		} catch (HibernateException e) {
			System.out.println("Não foi possível inserir o contato. Erro: " + e.getMessage());
		} finally {
			try{
				this.sessao.close();
			} catch (Throwable e) {
				System.out.println("Erro ao fechar operação de inserção. Mensagem: " + e.getMessage());
			}
		}		
	}
	public void atualizar(Questionario questionario)
	{
		try
		{
			this.sessao = HibernateUtil.getSessionFactory().openSession();
			this.transacao = this.sessao.beginTransaction();
			this.sessao.update(questionario);
			this.transacao.commit();
		} catch (HibernateException e)
		{
			System.out.println("Não foi possível alterar o contato. Erro: " + e.getMessage());
		} finally
		{
			try
			{
				if(this.sessao.isOpen())
				{
					this.sessao.close();
				}
			}
			catch(Throwable e)
			{
					System.out.println("Erro ao fechar a operação de atualização. Erro: " + e.getMessage());

			}
		}
		
	}
	
	public void excluir(Questionario questionario) 
	{
		try
		{
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.delete(questionario);
			transacao.commit();
		}
		catch(HibernateException e)
		{
			System.out.println("Não foi possível excluir o contato. Erro: " + e.getMessage());
		}
		finally
		{
			try
			{
				if(this.sessao.isOpen())
				{
					this.sessao.close();
				}
			}
			catch(Throwable e)
			{
				System.out.println("Erro ao fechar operação de exclusão. Mensagem: " + e.getMessage());
			}
		}
	}
	
	
	public List<Questionario> listar()
	{
		List<Questionario> questionario = null;
		try
		{
			this.sessao = HibernateUtil.getSessionFactory().openSession();
			this.transacao = this.sessao.beginTransaction();
			Criteria filtro = this.sessao.createCriteria(Questionario.class);
			questionario = (List<Questionario>) filtro.list();
			this.transacao.commit();
		} catch (Throwable e)
		{
			if(this.transacao.isActive())
				this.transacao.rollback();
		} finally
		{
			try
			{
				if(this.sessao.isOpen())
					this.sessao.close();
			}catch(Throwable e)
			{
				System.out.println("Erro ao fechar operação de listagem. Erro: " + e.getMessage());
			}
		}
		return questionario;
	}
	
	public static void main(String[] args){

		Questionario quest = new Questionario();
		Eventos evento = new Eventos();
		evento.setAno("2013");
		evento.setDescricao("Fórum das Águas");
		evento.setResponsavel("Cosme");
		evento.setLocal("Católica");
		
		quest.setEvento(evento);
		
		QuestionarioDao questionarioDao = new QuestionarioDao();
		
		questionarioDao.salvar(quest);
		

		//ContatosDAO contatoDao = new ContatosDAO();
		List<Questionario> quest2= null;
		quest2 = questionarioDao.listar();
		for(Questionario questionario: quest2)
		{
			System.out.println("Descrição: " + quest.getEvento().getDescricao());
			System.out.println(" ");
		}
	}

}
