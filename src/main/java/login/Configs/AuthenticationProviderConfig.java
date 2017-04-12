package login.Configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

@Configuration
public class AuthenticationProviderConfig implements AuthenticationProvider {

	@Autowired
	private DatabaseConfig databaseConfig;

//	@Bean(name="userDetailsService")
//	public UserDetailsService userDetailsService() {
//		
//		
//		
//		JdbcDaoImpl jdbcImpl = new JdbcDaoImpl();
//		jdbcImpl.setDataSource(databaseConfig.dataSource());
//		
//		jdbcImpl.setUsersByUsernameQuery("SELECT email as username, password, confirmed as enabled, CONCAT(SUBSTRING_INDEX(name, ' ', 1),' ',SUBSTRING_INDEX(name, ' ', -1)) AS name FROM users where email=?");
//		jdbcImpl.setAuthoritiesByUsernameQuery("SELECT email as username, role FROM users where email=?");
//		
//		return jdbcImpl;
//	}
	
		public AuthenticationManagerBuilder userDetailsService(AuthenticationManagerBuilder auth) throws Exception {
	    	
	    	auth.jdbcAuthentication().dataSource(databaseConfig.dataSource())
	    	.usersByUsernameQuery("SELECT email as username, password, confirmed as enabled, CONCAT(SUBSTRING_INDEX(name, ' ', 1),' ',SUBSTRING_INDEX(name, ' ', -1)) AS name FROM users where email=?")
	    	.authoritiesByUsernameQuery("SELECT email as username, role FROM users where email=?");
	    	
	    	return auth;
	       
	    }

		@Override
		public Authentication authenticate(Authentication arg0) throws AuthenticationException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean supports(Class<?> arg0) {
			// TODO Auto-generated method stub
			return false;
		}
	    
	}


