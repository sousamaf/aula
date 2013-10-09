package br.edu.catolica.tabelas;

import java.util.List;

import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import br.edu.catolica.conexao.HibernateUtil;

public class CompetenciasDao {
	private Session sessao;
	private Transaction transacao;

	public void salvar(Competencias competencias)
	{
		try{
			this.sessao = HibernateUtil.getSessionFactory().openSession();
			this.transacao = this.sessao.beginTransaction();
			this.sessao.save(competencias);
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
	public void atualizar(Competencias competencias)
	{
		try
		{
			this.sessao = HibernateUtil.getSessionFactory().openSession();
			this.transacao = this.sessao.beginTransaction();
			this.sessao.update(competencias);
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
	
	public void excluir(Competencias competencias) 
	{
		try
		{
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.delete(competencias);
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
	
	public Competencias getCompetencias(Integer id)
	{
		Competencias competencia = null;
		try
		{	
			this.sessao = HibernateUtil.getSessionFactory().openSession();
			this.transacao = this.sessao.beginTransaction();
			Criteria filtro = this.sessao.createCriteria(Competencias.class);
			filtro.add(Restrictions.eq("id", id));
			competencia = (Competencias) filtro.uniqueResult();
			this.transacao.commit();
		}catch(Throwable e)
		{
			if(this.transacao.isActive())
			{
				this.transacao.rollback();
			}
		} finally
		{
			try
			{ 
				if(this.sessao.isOpen())
				{ 
					this.sessao.close();
				}
			}catch(Throwable e)
			{
				System.out.println("Erro ao fechar operacao de busca. Erro: " + e.getMessage());
			}
			
		}
		return competencia;
	}
	
	public List<Competencias> listar()
	{
		List<Competencias> competencias = null;
		try
		{
			this.sessao = HibernateUtil.getSessionFactory().openSession();
			this.transacao = this.sessao.beginTransaction();
			Criteria filtro = this.sessao.createCriteria(Competencias.class);
			competencias = (List<Competencias>) filtro.list();
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
		return competencias;
	}
	
/*	public static void main(String[] args){

		Contatos contato1 = new Contatos();
		contato1.setName("Fulano7 da Silva");
		contato1.setEmail("fulanos7@hotmail.com");
		contato1.setLogin("fulano.s7");
		contato1.setTelefone("8407-9188");
		
		ContatosDAO contatoDao = new ContatosDAO();
		contato1 = contatoDao.getContato(6);
		contato1.setName("Contato da Silva");
		contatoDao.atualizar(contato1);
		

		//ContatosDAO contatoDao = new ContatosDAO();
		List<Contatos> contato2 = null;
		contato2 = contatoDao.listar();
		for(Contatos contato : contato2)
		{
			System.out.println("Nome: " + contato.getName());
			System.out.println("Login: " + contato.getLogin());
			System.out.println("Email: " + contato.getEmail());
			System.out.println("Telefone: " + contato.getTelefone());
			System.out.println(" ");
		}
	}
*/
}
