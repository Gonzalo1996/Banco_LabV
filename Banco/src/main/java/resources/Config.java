package resources;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import dao.UsuarioDao;
import servicio.UsuarioServicio;

@Configuration
@EnableTransactionManagement
public class Config {
	
	@Bean
	public UsuarioServicio serviceBean() {
		UsuarioServicio u = new UsuarioServicio();
		u.setDataAccess(dataAccessBean());
		return u;
	}
	
	@Bean
	public HibernateTransactionManager transactionManager() {
		return new HibernateTransactionManager(sessionFactoryBean().getObject());
	}
	
	@Bean
	public UsuarioDao dataAccessBean() {
		UsuarioDao u = new UsuarioDao();
		u.setSessionFactory(sessionFactoryBean().getObject());
		return u;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactoryBean() {
		Properties p = new Properties();
		p.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		p.put("show_sql", true);
		p.put("hibernate.hbm2ddl.auto", "update");
		
		LocalSessionFactoryBean r = new LocalSessionFactoryBean();
		r.setPackagesToScan("dominio");
		r.setDataSource(dataSourceBean());
		r.setHibernateProperties(p);
		
		return r;
	}
	
	@Bean
	public DriverManagerDataSource dataSourceBean() {
		DriverManagerDataSource r = new DriverManagerDataSource("jdbc:mysql://localhost:3306/Banco?createDatabaseIfNotExist=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "admin", "passw0rd");
		r.setDriverClassName("com.mysql.jdbc.Driver");
		
		return r;
	}
	
}
