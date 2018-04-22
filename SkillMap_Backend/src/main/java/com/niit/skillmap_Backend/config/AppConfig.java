package com.niit.skillmap_Backend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.skillmap_Backend.dao.EmployeeDAO;
import com.niit.skillmap_Backend.dao.EmployeeDAOImpl;
import com.niit.skillmap_Backend.model.Employee;

@Configuration
@ComponentScan("com.niit.skillmap_backend")
@EnableTransactionManagement

public class AppConfig {

	@Bean(name="datasource")
	public DataSource getDataSource()
	{
		BasicDataSource datasource=new BasicDataSource();
		datasource.setDriverClassName("org.h2.Driver");
		datasource.setUrl("jdbc:h2:tcp://localhost/~/CEB");
		datasource.setUsername("sa");
		datasource.setPassword("");
		System.out.println("Datasource");
		return datasource;
	}
	private Properties getHibernateProperties()
	{
		Properties prop=new Properties();
		prop.put("hibernate.show_sql", "true");
		prop.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		prop.put("hibernate.hbm2ddl.auto", "update");
		prop.put("hibernate.current_session_context_class","thread");

		System.out.println("Hibernate Properties");
		return prop;
	}
	
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(DataSource datasource)
	{
		LocalSessionFactoryBuilder sessionBuilder=new LocalSessionFactoryBuilder(datasource);
		sessionBuilder.addProperties(getHibernateProperties());
		//sessionBuilder.addAnnotatedClass(Employee.class);
		sessionBuilder.scanPackages("com.niit.skillmap_backend");
		System.out.println("Session Factory");
		return sessionBuilder.buildSessionFactory();
	}
	
	
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
		System.out.println("Transaction Manager");
		return transactionManager;
	}
	
	/*@Autowired
	@Bean(name="employeeDAO")
	public EmployeeDAO getEmployeeDAO(SessionFactory sessionFactory)
	{
		System.out.println("Employee DAO");
		return new EmployeeDAOImpl();
	}
	@Autowired
	@Bean(name="employee")
	public Employee getEmployee()
	{
		System.out.println("Employee");
		return new Employee();
	}

*/

	
}
