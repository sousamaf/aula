package br.catolica.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.catolica.conexao.HibernateUtil;
import br.catolica.model.Pessoa;

public class PessoaDAO {

	private Session sessao;
	
	public void salvar(Pessoa pessoa)
	{
		try
		{
			this.sessao = HibernateUtil.getSessionFactory();
			this.sessao.getTransaction().begin();
			this.sessao.persist(pessoa);
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
			if(this.sessao.isConnected())
				this.sessao.close();
		}
	}
	
	public void atualizar(Pessoa pessoa)
	{
		try 
		{
			this.sessao = HibernateUtil.getSessionFactory();
			this.sessao.getTransaction().begin();
			this.sessao.update(pessoa);
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

	public void excluir(Pessoa pessoa)
	{
		try
		{
			this.sessao = HibernateUtil.getSessionFactory();
			this.sessao.getTransaction().begin();
			this.sessao.delete(pessoa);
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
	
	public List<Pessoa> listar()
	{
		try 
		{
			this.sessao = HibernateUtil.getSessionFactory();
			@SuppressWarnings("unchecked")
			List<Pessoa> list = sessao.createCriteria(Pessoa.class)
					.addOrder(Order.asc("nome"))
					.list();
			return list;
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
			if(this.sessao.isConnected())
				this.sessao.close();
		}	
		return null;
	}
	
	public List<Pessoa> listar(String campo, String nomeUsuario)
	{
		try 
		{
			this.sessao = HibernateUtil.getSessionFactory();
			@SuppressWarnings("unchecked")
			List<Pessoa> list = sessao.createCriteria(Pessoa.class)
					.add(Restrictions.like(campo, nomeUsuario))
					.addOrder(Order.asc(campo))
					.list();
			return list;
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
		return null;
	}
	
	public Pessoa getPessoa(long l)
	{
		try
		{
			this.sessao = HibernateUtil.getSessionFactory();
			Pessoa u = (Pessoa) sessao.get(Pessoa.class, new Long(l));
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
