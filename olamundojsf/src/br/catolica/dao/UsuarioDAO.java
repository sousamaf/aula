package br.catolica.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.catolica.conexao.HibernateUtil;
import br.catolica.model.Usuario;

public class UsuarioDAO {

	private Session sessao;
	
	public void salvar(Usuario usuario)
	{
		try
		{
			this.sessao = HibernateUtil.getSessionFactory();
			this.sessao.getTransaction().begin();
			this.sessao.persist(usuario);
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
	
	public void atualizar(Usuario usuario)
	{
		try 
		{
			this.sessao = HibernateUtil.getSessionFactory();
			this.sessao.getTransaction().begin();
			this.sessao.update(usuario);
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

	public void excluir(Usuario usuario)
	{
		try
		{
			this.sessao = HibernateUtil.getSessionFactory();
			this.sessao.getTransaction().begin();
			this.sessao.delete(usuario);
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
	
	public List<Usuario> listar()
	{
		try 
		{
			this.sessao = HibernateUtil.getSessionFactory();
			@SuppressWarnings("unchecked")
			List<Usuario> list = sessao.createCriteria(Usuario.class)
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
				this.sessao.close();
		}	
		return null;
	}
	
	public List<Usuario> listar(String campo, String nomeUsuario)
	{
		try 
		{
			this.sessao = HibernateUtil.getSessionFactory();
			@SuppressWarnings("unchecked")
			List<Usuario> list = sessao.createCriteria(Usuario.class)
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
	
	public Usuario getUsuario(long l)
	{
		try
		{
			this.sessao = HibernateUtil.getSessionFactory();
			Usuario u = (Usuario) sessao.get(Usuario.class, new Long(l));
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
