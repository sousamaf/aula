package br.catolica.seguranca.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	DataSource dataSource;
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("marco").password("1").roles("USER");
		auth.jdbcAuthentication()
	        .dataSource(dataSource)                
	        .usersByUsernameQuery("select username as principal, password as credentials, true from users where username = ?")               
	        .authoritiesByUsernameQuery("select username as principal, authority as role from authorities where username = ?")                
	        .rolePrefix("ROLE_");
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/resources/**").permitAll() 
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()                                    
                .permitAll();
    }
}