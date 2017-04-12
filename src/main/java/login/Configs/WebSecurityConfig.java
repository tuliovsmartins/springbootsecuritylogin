package login.Configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;

import login.Configs.Encrypt;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public Encrypt encrypt;
	
	@Autowired
	CustomSuccessHandler customSuccessHandler;
	
	@Autowired
	private DatabaseConfig databaseConfig;
	
	
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
    	
    	auth.jdbcAuthentication().dataSource(databaseConfig.dataSource())
	    	.usersByUsernameQuery("SELECT email as username, password, confirmed as enabled, CONCAT(SUBSTRING_INDEX(name, ' ', 1),' ',SUBSTRING_INDEX(name, ' ', -1)) AS name FROM users where email=?")
	    	.authoritiesByUsernameQuery("SELECT email as username, role FROM users where email=?")
	    	.passwordEncoder(encrypt.passwordEncoder());
    	
    }
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
	        .authorizeRequests()
	        .antMatchers("/assets/**", "/js/**", "/css/**", "/img/**", "/fonts/**","/font-awesome/**","/", "/login").permitAll()
	        .anyRequest().authenticated()
	        .and()
	        .httpBasic()
	        .and()
        .formLogin()
	        .loginPage("/login")
	        .permitAll()
	        .successHandler(customSuccessHandler)
	        .and()
	     .sessionManagement()
			.maximumSessions(-1)
			.sessionRegistry(sessionRegistry())
			.expiredUrl("/logout")
			.and().and()
	    .logout()
        	.permitAll()
        	.and().csrf().disable();
		
	}
	
	@Bean
	public SessionRegistry sessionRegistry() {
		return new SessionRegistryImpl();
	}
}
