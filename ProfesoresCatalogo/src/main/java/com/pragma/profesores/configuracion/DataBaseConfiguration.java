package com.pragma.profesores.configuracion;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DataBaseConfiguration {
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setPackagesToScan("com.pragma.profespres.model");
		sessionFactoryBean.setHibernateProperties(hibernateProperties());
		
		return sessionFactoryBean;
	
	}
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://:3306/bd_original"
				+ "?useUnicode=true"
				+ "&useJDBCCompliantTimezoneShift=true"
				+ "&useLegacyDatetimeCode=false"
				+ "&serverTimezone=UTC");
		dataSource.setUsername("luishdezortega");
		dataSource.setPassword("Luis231995");
		
		return dataSource;
	}
	
	
	public Properties hibernateProperties() {
		Properties propierties = new Properties();
		propierties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		propierties.put("show_sql", "true");
		
		return propierties;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(sessionFactory().getObject());
		
		return hibernateTransactionManager;
	}

}
