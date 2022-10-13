package dev.palhano.forum.alura.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Override //configuração de autenticação
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
	}
	
	@Override//configuração de autorização
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers(HttpMethod.GET,"/topicos").permitAll()
			.antMatchers(HttpMethod.GET,"/topicos/*").permitAll()
			.anyRequest().authenticated()
			.and().formLogin();
	}
	
	@Override//configuração de recusos estativos
	public void configure(WebSecurity web) throws Exception {
		
	}
	
}
