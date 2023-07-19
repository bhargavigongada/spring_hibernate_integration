package com.tmf.spring.demo.spring_hibernate_integration.config;

import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.tmf.spring.demo.spring_hibernate_integration.models.Product;

@Configuration
@ComponentScan(basePackages = "com.tmf")
@EnableTransactionManagement
public class SpringConfig {
	
	// DataSource Properties
	@Bean
	public BasicDataSource getdataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/cijd_13hb");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}
	
	//Hibernate Properties
	@Bean
	public Properties getHibernateProperties() {
		Properties p = new Properties();
		p.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		p.setProperty("hibernate.hbm2ddl.auto", "update");
		p.setProperty("hibernate.show_sql", "true");
		return p;
	}
	
	//Creating SessionFactory object
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
		sf.setHibernateProperties(getHibernateProperties());
		sf.setDataSource(getdataSource());
		sf.setAnnotatedClasses(new  Class[] {Product.class});
		return sf;
	}
	
	//TransactionManager
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager txm = new HibernateTransactionManager();
		txm.setSessionFactory(sessionFactory);
		return txm;
	}
}
