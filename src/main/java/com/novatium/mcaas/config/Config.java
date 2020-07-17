package com.novatium.mcaas.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@Configuration
@EnableTransactionManagement

public class Config {
	@Autowired
	private Environment env; 
	@ConfigurationProperties(prefix = "spring.mysql.datasource")
	@Bean(name="mysqlDataSource")
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("spring.mysql.datasource.driverClassName"));
		dataSource.setUrl(env.getProperty("spring.mysql.datasource.url"));
		dataSource.setUsername(env.getProperty("spring.mysql.datasource.username"));
		dataSource.setPassword(env.getProperty("spring.mysql.datasource.password"));
		return dataSource;
	}
	@Bean(name="mysqlEntityManager")
	public LocalSessionFactoryBean sessionFactory( ) {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("com.novatium.mcaas.*");
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", env.getProperty("spring.mysql.datasource.jpa.database-platform"));
		hibernateProperties.put("hibernate.show_sql", true);
		hibernateProperties.put("hibernate.hbm2ddl.auto", env.getProperty("spring.mysql.datasource.jpa.hibernate.ddl-auto"));
		sessionFactory.setHibernateProperties(hibernateProperties);
 
		return sessionFactory;
	}
	
	@Bean(name="mysqlTransactionManager")
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}
	
	}






/*
	@Bean(name="mysqlEntityManager")
	@PersistenceContext(unitName = "firstPersistence")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(
			@Qualifier("mysqlDataSource") final DataSource dataSource) {
		final LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setJpaVendorAdapter(this.vendorAdaptor());
		entityManagerFactoryBean.setDataSource(dataSource);
		entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		entityManagerFactoryBean.setPersistenceUnitName("firstPersistence");
		entityManagerFactoryBean.setPackagesToScan("");
		entityManagerFactoryBean.setJpaProperties(this.jpaHibernateProperties());
		entityManagerFactoryBean.afterPropertiesSet();
		return entityManagerFactoryBean;

	}
	private HibernateJpaVendorAdapter vendorAdaptor() {
		final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

		return vendorAdapter;
	}

	private Properties jpaHibernateProperties() {
		final Properties properties = new Properties();

		return properties;
	}
	@Bean(name="mysqlTransactionManager")
	public PlatformTransactionManager dbTransactionManager(@Qualifier("mysqlEntityManager") final EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(
				entityManagerFactory(dataSource()).getObject());
		return transactionManager;
	}*/

