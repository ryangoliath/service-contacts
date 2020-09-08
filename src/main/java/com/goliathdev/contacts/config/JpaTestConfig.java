package com.goliathdev.contacts.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Profile("test")
@Configuration
@EnableJpaRepositories(basePackages = "com.goliathdev.contacts.repo")
@PropertySource("classpath:application-test.properties")
@EnableTransactionManagement
public class JpaTestConfig {

	
}
