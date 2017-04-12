package login.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import login.Configs.Encrypt;
import login.Dao.UserDao;
import login.View.Model.UserDataVM;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private Encrypt encrypt;
	
	public boolean checkDuplicateEmail(String email, UserDataVM userDataVM){
		
		UserDataVM result = userDao.getByEmail(email);
		
		if(result.getEmail() == "" || result.getEmail() == null){

			return true;
			
		}else{
			
			return false;
		}
	}
	
	public void createUser(UserDataVM userDataVM){
		
		userDataVM.setPassword(encrypt.passwordEncoder().encode(userDataVM.getPassword()));
		userDataVM.setRole("USER");
		userDao.create(userDataVM);
		 
		return;
		
	}
	
	public boolean validatePassword(UserDataVM user, String password_rep){
		
		if (user.getPassword().equals(password_rep)) {  		
			return true;
	  	}else{
	  		
			return false;
	  	}
	}
	
	public UserDataVM getByEmail(String email){
		 
		UserDataVM result = null ;
		
		try {
				
				result = userDao.getByEmail(email);  
		    
			}
			    catch (Exception ex) {
			     return result;
		    }
		    return result;
		
		
	}
	
	
}
