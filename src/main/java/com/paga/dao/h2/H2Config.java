package com.paga.dao.h2;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/*
 * Copyright 2015-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**

 */
@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "h2EntityManagerFactory", transactionManagerRef = "h2TransactionManager")
public class H2Config {
	@Resource
	private Properties jpaProperties;

	@Bean
	@ConfigurationProperties(prefix = "spring.secondary.datasource")
    public DataSource h2DataSource() {
//		return new HikariDataSource(new HikariConfig(properties));
		 return DataSourceBuilder.create().build();
//        return properties.initializeDataSourceBuilder().build();
	}
	
	@Bean
	PlatformTransactionManager h2TransactionManager() {
		return new JpaTransactionManager(h2EntityManagerFactory().getObject());
	}

	@Bean
	LocalContainerEntityManagerFactoryBean h2EntityManagerFactory() {

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		//vendorAdapter.setGenerateDdl(true);
		vendorAdapter.setDatabasePlatform("org.hibernate.dialect.H2Dialect");
		//vendorAdapter.setShowSql(true);

		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

		factoryBean.setDataSource(h2DataSource());
		factoryBean.setJpaVendorAdapter(vendorAdapter);
		factoryBean.setPackagesToScan(H2Config.class.getPackage().getName());
		factoryBean.setJpaProperties(jpaProperties);

		return factoryBean;
	}

}