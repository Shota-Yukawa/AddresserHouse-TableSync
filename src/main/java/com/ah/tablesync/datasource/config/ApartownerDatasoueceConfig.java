package com.ah.tablesync.datasource.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
@EnableJpaRepositories(basePackages = "com.ah.tablesync.datasource.repository.apartowner", entityManagerFactoryRef = "apartownerEntityManager", transactionManagerRef = "apartownerTransactionManager")

public class ApartownerDatasoueceConfig {

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.apartowner")
	public DataSourceProperties apartownerProperties() {
		return new DataSourceProperties();
	}

	@Bean
	@Autowired // 省略可
	public DataSource apartownerDataSource(@Qualifier("apartownerProperties") DataSourceProperties properties) {
		return properties.initializeDataSourceBuilder().build();
	}

	@Bean
	@Autowired // 省略可
	public LocalContainerEntityManagerFactoryBean apartownerEntityManager(EntityManagerFactoryBuilder builder,
			@Qualifier("apartownerDataSource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("com.ah.tablesync.datasource.entity.apartowner")
				.persistenceUnit("apartowner").build();
	}

	@Bean
	@Autowired // 省略可
	public JpaTransactionManager apartownerTransactionManager(
			@Qualifier("apartownerEntityManager") LocalContainerEntityManagerFactoryBean apartownerEntityManager) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(apartownerEntityManager.getObject());
		return transactionManager;
	}

}
