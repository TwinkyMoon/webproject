package com.uptotech.server_tutor.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.apache.commons.dbcp.BasicDataSource;

import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

@Configuration
@ComponentScan("com.uptotech.server_tutor")
@EnableWebMvc
@EnableTransactionManagement
public class Config extends WebMvcConfigurerAdapter {
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	/*
	 * @Override public void
	 * configureDefaultServletHandling(DefaultServletHandlerConfigurer
	 * configurer) { configurer.enable(); }
	 */

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	String url =// "jdbc:mysql://" + "127.10.221.130" + ":" + "3306" + "/" + "basictutor";
			//"jdbc:mysql//mysql:3306/basictutor";
			"jdbc:mysql://" + "sql11.freesqldatabase.com" + ":" + "3306" + "/" + "sql11199469";
	String user = "sql11199469";
	String password = "abveRCFyUM";
	
//	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//	static final String url = "jdbc:mysql://" + "127.10.221.130" + ":" + "3306" + "/" + "basictutor";
//	static final String user = "adminTVitrUP";
//	static final String password = "n-WzIMwcQDcQ";

	@Bean(name = "dataSource")
	public DataSource getDataSource() {
	
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(JDBC_DRIVER);
		dataSource.setUrl(url);
		dataSource.setUsername(user);
		dataSource.setPassword(password);
		System.out.print(" Diana Here getDataSource1 " + dataSource.getUrl() + " " + dataSource.getUsername() + " \n"); 
		return dataSource;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public LocalSessionFactoryBean getSessionFactory() {
		System.out.print(" Diana Here getSessionFactory1"+ " \n");
		LocalSessionFactoryBean  sessionFactory = new LocalSessionFactoryBean ();
		sessionFactory.setDataSource(getDataSource());
		sessionFactory.setPackagesToScan("com.uptotech.server_tutor.model");
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}

	private Properties hibernateProperties() {
		System.out.print(" Diana HerehibernateProperties"+ " \n");
		 Properties properties = new Properties();
		 properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
	        properties.put("hibernate.show_sql", "true");
	        properties.put("hibernate.format_sql", "true");
	        return properties;   
	}
	
	 @Bean
	    @Autowired
	    public HibernateTransactionManager transactionManager(SessionFactory s) {

	       HibernateTransactionManager txManager = new HibernateTransactionManager();
	       txManager.setSessionFactory(s);
	 /*  	try {
			System.out.print(" Diana Here 1"+ " \n " + txManager.getDataSource().getConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	       return txManager;
	    }
	

}
