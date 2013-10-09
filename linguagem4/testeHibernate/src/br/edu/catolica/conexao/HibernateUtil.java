package br.edu.catolica.conexao;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
 
	private static SessionFactory configureSessionFactory() throws HibernateException {
		try{
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();        
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		return sessionFactory;
		} catch (Throwable e)
		{
			System.out.println("Criação inicial do objeto SessionFactory falhou. Erro: " + e);
			throw new ExceptionInInitializerError(e); 
		}
	}
 
    public static SessionFactory getSessionFactory() {
        return configureSessionFactory();
    }
}
