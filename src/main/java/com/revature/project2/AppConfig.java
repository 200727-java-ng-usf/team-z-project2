package com.revature.project2;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Configuration
@ComponentScan
@EnableTransactionManagement
public class AppConfig {



    @Value("org.postgresql.Driver")
    private String dbDriver;

    @Value("jdbc:postgresql://java-ng-usf-200727.cwdevtt9ruq7.us-east-2.rds.amazonaws.com:5432/postgres")
    private String dbUrl;

    @Value("public")
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
        hibernateProps.setProperty(Environment.HBM2DDL_AUTO, "validate");
        return hibernateProps;
    }

}
