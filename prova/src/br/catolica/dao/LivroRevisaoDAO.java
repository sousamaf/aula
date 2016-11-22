package br.catolica.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.catolica.conexao.HibernateUtil;
import br.catolica.model.LivroRevisao;;

public class LivroRevisaoDAO {

	private Session sessao;
	
	public void salvar(LivroRevisao livroRevisao)
	{
		try
		{
			this.sessao = HibernateUtil.getSessionFactory();
			this.sessao.getTransaction().begin();
			this.sessao.persist(livroRevisao);
			this.sessao.getTransaction().commit();
		} 
		catch(HibernateException ex) 
		{
			System.out.println("Não foi possível inserir o contato. Erro: " + ex.getMessage());
		} 
		catch(Throwable e) 
		{
			System.out.println("Erro ao tentar acesso ao banco. Mensagem: " + e.getMessage());
		} 
		finally 
		{
				this.sessao.close();
		}
	}
	
	public void atualizar(LivroRevisao livroRevisao)
	{
		try 
		{
			this.sessao = HibernateUtil.getSessionFactory();
			this.sessao.getTransaction().begin();
			this.sessao.update(livroRevisao);
			this.sessao.getTransaction().commit();
		} 
		catch(HibernateException ex) 
		{
			this.sessao.getTransaction().rollback();
			System.out.println("Não foi possível inserir o contato. Erro: " + ex.getMessage());
		} 
		catch(Throwable e) 
		{
			System.out.println("Erro ao tentar acesso ao banco. Mensagem: " + e.getMessage());
		} 
		finally 
		{
				this.sessao.close();
		}		
	}

	public void excluir(LivroRevisao livroRevisao)
	{
		try
		{
			this.sessao = HibernateUtil.getSessionFactory();
			this.sessao.getTransaction().begin();
			this.sessao.delete(livroRevisao);
			this.sessao.getTransaction().commit();
		}
		catch(HibernateException e)
		{
			System.out.println("Não foi possível excluir o contato. Erro: " + e.getMessage());
		}
		finally
		{
			this.sessao.close();
		}

	}
	
	public List<LivroRevisao> listar()
	{
		try 
		{
			this.sessao = HibernateUtil.getSessionFactory();
			@SuppressWarnings("unchecked")
			List<LivroRevisao> list = sessao.createCriteria(LivroRevisao.class)
					.addOrder(Order.desc("data_revisao"))
					.list();
			return list;
		} 
		catch(HibernateException ex) 
		{
			System.out.println("Não foi possível exibir a lista de dados. Erro: " + ex.getMessage());
		} 
		catch(Throwable e) 
		{
			System.out.println("Erro ao tentar acesso ao banco. Mensagem: " + e.getMessage());
		} 
		finally 
		{
				this.sessao.close();
		}	
		return null;
	}
	
	public List<LivroRevisao> listar(String campo, String nomeUsuario)
	{
		try 
		{
			this.sessao = HibernateUtil.getSessionFactory();
			@SuppressWarnings("unchecked")
			List<LivroRevisao> list = sessao.createCriteria(LivroRevisao.class)
					.add(Restrictions.like(campo, nomeUsuario))
					.addOrder(Order.asc(campo))
					.list();
			return list;
		} 
		catch(HibernateException ex) 
		{
			System.out.println("Não foi possível exibir os dados. Erro: " + ex.getMessage());
		} 
		catch(Throwable e) 
		{
			System.out.println("Erro ao tentar acesso ao banco. Mensagem: " + e.getMessage());
		} 
		finally 
		{
				this.sessao.close();
		}	
		return null;
	}
	
	public LivroRevisao getLivro(long l)
	{
		try
		{
			this.sessao = HibernateUtil.getSessionFactory();
			LivroRevisao u = (LivroRevisao) sessao.get(LivroRevisao.class, new Long(l));
			return u;
		}
		catch(HibernateException e)
		{
			System.out.println("Problemas ao tentar buscar usuario por id. Erro: " + e.getMessage());
		}
		finally
		{
			this.sessao.close();
		}
		return null;
	}
}
