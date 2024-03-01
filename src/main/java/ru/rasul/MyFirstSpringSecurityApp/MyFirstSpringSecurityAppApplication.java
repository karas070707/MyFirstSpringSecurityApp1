package ru.rasul.MyFirstSpringSecurityApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
public class MyFirstSpringSecurityAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyFirstSpringSecurityAppApplication.class, args);
	}
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		return http
				.httpBasic().and()
				.authorizeHttpRequests()
				.anyRequest().authenticated().and()
				.build();
	}

}
