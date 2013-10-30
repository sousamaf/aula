package br.edu.catolica.tabelas;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.edu.catolica.conexao.HibernateUtil;

public class ProdutosDao {

	private Session sessao;
	private Transaction transacao;

	public void salvar(Produtos produto)
	{
		try{
			this.sessao = HibernateUtil.getSessionFactory().openSession();
			this.transacao = this.sessao.beginTransaction();
			this.sessao.save(produto);
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
	public void atualizar(Produtos produto)
	{
		try
		{
			this.sessao = HibernateUtil.getSessionFactory().openSession();
			this.transacao = this.sessao.beginTransaction();
			this.sessao.update(produto);
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
	
	public void excluir(Produtos produto) 
	{
		try
		{
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.delete(produto);
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
	
	public Produtos getContato(Integer id)
	{
		Produtos produto = null;
		try
		{	
			this.sessao = HibernateUtil.getSessionFactory().openSession();
			this.transacao = this.sessao.beginTransaction();
			Criteria filtro = this.sessao.createCriteria(Produtos.class);
			filtro.add(Restrictions.eq("id", id));
			produto = (Produtos) filtro.uniqueResult();
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
		return produto;
	}
	
	public List<Produtos> listar()
	{
		List<Produtos> produtos = null;
		try
		{
			this.sessao = HibernateUtil.getSessionFactory().openSession();
			this.transacao = this.sessao.beginTransaction();
			Criteria filtro = this.sessao.createCriteria(Produtos.class);
			produtos = (List<Produtos>) filtro.list();
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
		return produtos;
	}
}
