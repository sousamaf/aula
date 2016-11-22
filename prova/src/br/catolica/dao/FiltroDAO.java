package br.catolica.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.catolica.conexao.HibernateUtil;
import br.catolica.model.Filtro;
import br.catolica.model.LivroRevisao;

public class FiltroDAO {

	private Session sessao;
	
	public void salvar(Filtro filtro)
	{
		try
		{
			this.sessao = HibernateUtil.getSessionFactory();
			this.sessao.getTransaction().begin();
			this.sessao.persist(filtro);
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
	
	public void atualizar(Filtro filtro)
	{
		try 
		{
			this.sessao = HibernateUtil.getSessionFactory();
			this.sessao.getTransaction().begin();
			this.sessao.update(filtro);
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

	public void excluir(Filtro filtro)
	{
		try
		{
			this.sessao = HibernateUtil.getSessionFactory();
			this.sessao.getTransaction().begin();
			this.sessao.delete(filtro);
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
	
	public List<Filtro> listar()
	{
		try 
		{
			this.sessao = HibernateUtil.getSessionFactory();
			@SuppressWarnings("unchecked")
			List<Filtro> list = sessao.createCriteria(Filtro.class)
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
	
	public List<Filtro> listar(String campo, Long id)
	{
		try 
		{
			this.sessao = HibernateUtil.getSessionFactory();
			@SuppressWarnings("unchecked")
			List<Filtro> list = sessao.createCriteria(Filtro.class)
					.add(Restrictions.eq(campo, id))
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
	
	public List<Filtro> listarNaoAvaliados(Long idPessoa)
	{
		try 
		{
			this.sessao = HibernateUtil.getSessionFactory();
			
			@SuppressWarnings("unchecked")
			List<LivroRevisao> livrosRevisados = sessao.createCriteria(LivroRevisao.class)
					.add(Restrictions.eq("pessoa.idPessoa", idPessoa))
					.list();
			
			Long[] revisados = new Long[livrosRevisados.size()];

			int i = 0;
			for(LivroRevisao lr: livrosRevisados)
			{
				revisados[i] = lr.getLivro().getIdLivro();
				i++;
			}
			
			@SuppressWarnings("unchecked")
			List<Filtro> list = sessao.createCriteria(Filtro.class)
					.add(Restrictions.eq("pessoa.idPessoa", idPessoa))
					.add(
							Restrictions.not(
									Restrictions.in("livro.idLivro", revisados)
									)
							)
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

	public List<Filtro> listarAvaliados(Long idPessoa)
	{
		try 
		{
			this.sessao = HibernateUtil.getSessionFactory();
			
			@SuppressWarnings("unchecked")
			List<LivroRevisao> livrosRevisados = sessao.createCriteria(LivroRevisao.class)
					.add(Restrictions.eq("pessoa.idPessoa", idPessoa))
					.list();
			
			Long[] revisados = new Long[livrosRevisados.size()];

			int i = 0;
			for(LivroRevisao lr: livrosRevisados)
			{
				revisados[i] = lr.getLivro().getIdLivro();
				i++;
			}
			
			@SuppressWarnings("unchecked")
			List<Filtro> list = sessao.createCriteria(Filtro.class)
					.add(Restrictions.eq("pessoa.idPessoa", idPessoa))
					.add(
									Restrictions.in("livro.idLivro", revisados)
							)
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

	
	public Filtro getFiltro(long l)
	{
		try
		{
			this.sessao = HibernateUtil.getSessionFactory();
			Filtro u = (Filtro) sessao.get(Filtro.class, new Long(l));
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
