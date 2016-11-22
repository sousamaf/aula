package br.catolica.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.catolica.conexao.HibernateUtil;
import br.catolica.model.Livro;

public class LivroDAO {

	private Session sessao;
	
	public void salvar(Livro livro)
	{
		try
		{
			this.sessao = HibernateUtil.getSessionFactory();
			this.sessao.getTransaction().begin();
			this.sessao.persist(livro);
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
	
	public void atualizar(Livro livro)
	{
		try 
		{
			this.sessao = HibernateUtil.getSessionFactory();
			this.sessao.getTransaction().begin();
			this.sessao.update(livro);
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

	public void excluir(Livro livro)
	{
		try
		{
			this.sessao = HibernateUtil.getSessionFactory();
			this.sessao.getTransaction().begin();
			this.sessao.delete(livro);
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
	
	public List<Livro> listar()
	{
		try 
		{
			this.sessao = HibernateUtil.getSessionFactory();
			@SuppressWarnings("unchecked")
			List<Livro> list = sessao.createCriteria(Livro.class)
					.addOrder(Order.asc("referencia"))
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
	
	public List<Livro> listar(String campo, String nomeUsuario)
	{
		try 
		{
			this.sessao = HibernateUtil.getSessionFactory();
			@SuppressWarnings("unchecked")
			List<Livro> list = sessao.createCriteria(Livro.class)
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
	
	public Livro getLivro(long l)
	{
		try
		{
			this.sessao = HibernateUtil.getSessionFactory();
			Livro u = (Livro) sessao.get(Livro.class, new Long(l));
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
