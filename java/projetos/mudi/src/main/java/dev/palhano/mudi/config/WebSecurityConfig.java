package dev.palhano.mudi.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
//				.antMatchers("/","/home").permitAll()
				.anyRequest().authenticated()
			.and()
//				.httpBasic();
				.formLogin(form -> form
								.loginPage("/login")
								.defaultSuccessUrl("/home", true)
								.permitAll())
				.logout(logout -> logout.logoutUrl("/logout"))
				.csrf().disable() // Pesquisar depois sobre o CSRF 
				;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder passEncoder = new BCryptPasswordEncoder();
		
		UserDetails user = User.builder()
							.username("ana")
							.password(passEncoder.encode("ana"))
							.roles("USER")
							.build();
		
		auth.jdbcAuthentication()
			.dataSource(dataSource)
			.passwordEncoder(passEncoder)
//			.withUser(user)
			;
	}
	
	
	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		UserDetails user = User.withDefaultPasswordEncoder()
					.username("vitor")
					.password("vitor")
					.roles("USER")
					.build();
		
		return new InMemoryUserDetailsManager(user);
	}
}
