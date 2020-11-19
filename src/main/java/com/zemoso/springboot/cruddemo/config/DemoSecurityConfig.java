package com.zemoso.springboot.cruddemo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	// add a reference to our security data source
	
	@Autowired
	private DataSource securityDataSource;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// use jdbc authentication ... oh yeah!!!
		
		auth.jdbcAuthentication().dataSource(securityDataSource);
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
				//.anyRequest().authenticated()
			.antMatchers("/").hasAnyRole("USER","ADMIN")
			.antMatchers("/books/showFormForAdd/**").hasRole("ADMIN")
			.antMatchers("/books/showFormForUpdate/**").hasRole("ADMIN")
			.antMatchers("/books/delete/**").hasRole("ADMIN")


			.and()
			.formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/authenticateTheUser")
				.permitAll()
				.and()
				.logout().logoutRequestMatcher(new AntPathRequestMatcher("/books/logout")).logoutSuccessUrl("/login")
				.and()
				.exceptionHandling().accessDeniedPage("/books/access-denied");
		
	}
		
}






