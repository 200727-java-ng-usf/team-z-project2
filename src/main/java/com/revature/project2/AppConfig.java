package com.revature.project2;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@EnableWebMvc // lets Spring see web annotations
@Configuration // comment, another comment
@ComponentScan
@EnableTransactionManagement // there are transactional annotations that Spring needs to see. Without this, Spring will ignore them
//@PropertySource("classpath:application.properties")
public class AppConfig implements WebMvcConfigurer, WebApplicationInitializer {

    @Value("org.postgresql.Driver")
    private String dbDriver;

    @Value("jdbc:postgresql://java-ng-usf-200727.cwdevtt9ruq7.us-east-2.rds.amazonaws.com:5432/postgres")
    private String dbUrl;

    @Value("HatsMall")
    private String dbSchema;

    @Value("postgres")
    private String dbUsername;

    @Value("fake-password")
    private String dbPassword;

    @Bean
    public BasicDataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(dbDriver);
        dataSource.setUrl(dbUrl);
        dataSource.setDefaultSchema(dbSchema);
        dataSource.setUsername(dbUsername);
        dataSource.setPassword(dbPassword);
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.revature.project2.models");
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    @Bean
    public PlatformTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }

    private final Properties hibernateProperties() {
        Properties hibernateProps = new Properties();
        hibernateProps.setProperty(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL95Dialect");
        hibernateProps.setProperty(Environment.SHOW_SQL, "true");
        hibernateProps.setProperty(Environment.FORMAT_SQL, "true");
        hibernateProps.setProperty(Environment.HBM2DDL_AUTO, "create");
        hibernateProps.setProperty(Environment.HBM2DDL_IMPORT_FILES, "import.sql");
        return hibernateProps;
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // the content of this method is the equivalent of the entire xml file for the xml configuration

        AnnotationConfigWebApplicationContext container = new AnnotationConfigWebApplicationContext();
        container.register(AppConfig.class); // can register multiple classes!

        servletContext.addListener(new ContextLoaderListener(container));
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(container));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}