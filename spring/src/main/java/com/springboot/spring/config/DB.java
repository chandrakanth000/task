package com.springboot.spring.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Configuration
@ConfigurationProperties("spring.datasource")
@SuppressWarnings("unused")
public class DB {
    private String driverClassName;
	private String url;
	private String userName;
	private String password;

    @Profile("develop")
	@Bean
	public String devDatabaseConnection() {
		
		System.out.println("develop start");
		System.out.println(driverClassName);
		System.out.println(url);
		return "H2 Connection";
		
	}
	
    @Profile("test")
	@Bean
	public String testDatabaseConnection() {
		
		System.out.println("test start");
		System.out.println(driverClassName);
		System.out.println(url);
		return "Test Connection";
		
	}
    
}
