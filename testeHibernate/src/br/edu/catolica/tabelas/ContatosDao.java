package br.edu.catolica.tabelas;

import java.util.List;

import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import br.edu.catolica.conexao.HibernateUtil;

public class ContatosDao {
	private Session sessao;
	private Transaction transacao;

	public void salvar(Contatos contato)
	{
		try{
			this.sessao = HibernateUtil.getSessionFactory().openSession();
			this.transacao = this.sessao.beginTransaction();
			this.sessao.save(contato);
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
	public void atualizar(Contatos contato)
	{
		try
		{
			this.sessao = HibernateUtil.getSessionFactory().openSession();
			this.transacao = this.sessao.beginTransaction();
			this.sessao.update(contato);
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
	
	public void excluir(Contatos contato) 
	{
		try
		{
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.delete(contato);
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
	
	public Contatos getContato(Integer id)
	{
		Contatos contato = null;
		try
		{	
			this.sessao = HibernateUtil.getSessionFactory().openSession();
			this.transacao = this.sessao.beginTransaction();
			Criteria filtro = this.sessao.createCriteria(Contatos.class);
			filtro.add(Restrictions.eq("id", id));
			contato = (Contatos) filtro.uniqueResult();
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
		return contato;
	}
	
	public List<Contatos> listar()
	{
		List<Contatos> contatos = null;
		try
		{
			this.sessao = HibernateUtil.getSessionFactory().openSession();
			this.transacao = this.sessao.beginTransaction();
			Criteria filtro = this.sessao.createCriteria(Contatos.class);
			contatos = (List<Contatos>) filtro.list();
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
		return contatos;
	}
	
	public static void main(String[] args){

		Contatos contato1 = new Contatos();
		contato1.setName("Majully");
		contato1.setEmail("kleber@hotmail.com");
		contato1.setLogin("majully");
		contato1.setTelefone("8407-6969");
		
		ContatosDao contatoDao = new ContatosDao();
		//contato1 = contatoDao.getContato(2);
		//contato1.setName("Contato da Silva");
		contatoDao.salvar(contato1);
		

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

}
