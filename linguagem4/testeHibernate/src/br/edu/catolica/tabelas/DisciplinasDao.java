package br.edu.catolica.tabelas;

import java.util.List;

import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import br.edu.catolica.conexao.HibernateUtil;

public class DisciplinasDao {
	private Session sessao;
	private Transaction transacao;

	public void salvar(Disciplinas disciplina)
	{
		try{
			this.sessao = HibernateUtil.getSessionFactory().openSession();
			this.transacao = this.sessao.beginTransaction();
			this.sessao.save(disciplina);
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
	public void atualizar(Disciplinas disciplina)
	{
		try
		{
			this.sessao = HibernateUtil.getSessionFactory().openSession();
			this.transacao = this.sessao.beginTransaction();
			this.sessao.update(disciplina);
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
	
	public void excluir(Disciplinas disciplina) 
	{
		try
		{
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.delete(disciplina);
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
	
	public Disciplinas getContato(Integer id)
	{
		Disciplinas disciplina = null;
		try
		{	
			this.sessao = HibernateUtil.getSessionFactory().openSession();
			this.transacao = this.sessao.beginTransaction();
			Criteria filtro = this.sessao.createCriteria(Disciplinas.class);
			filtro.add(Restrictions.eq("id", id));
			disciplina = (Disciplinas) filtro.uniqueResult();
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
		return disciplina;
	}
	
	public List<Disciplinas> listar()
	{
		List<Disciplinas> disciplinas = null;
		try
		{
			this.sessao = HibernateUtil.getSessionFactory().openSession();
			this.transacao = this.sessao.beginTransaction();
			Criteria filtro = this.sessao.createCriteria(Contatos.class);
			disciplinas = (List<Disciplinas>) filtro.list();
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
		return disciplinas;
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
