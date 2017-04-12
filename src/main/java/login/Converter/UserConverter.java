package login.Converter;

import org.springframework.stereotype.Component;

import login.Entity.User;
import login.View.Model.UserDataVM;

@Component
public class UserConverter {
	
	public User convert(UserDataVM userDataVM){
		
		User user = new User();
		
		user.setBirthdate(userDataVM.getBirthdate());
		user.setCity(userDataVM.getCity());
		user.setConfirmcode(userDataVM.getConfirmcode());
		user.setConfirmed(userDataVM.getConfirmed());
		user.setCowntry(userDataVM.getCowntry());
		user.setEmail(userDataVM.getEmail());
		user.setId(userDataVM.getId());
		user.setName(userDataVM.getName());
		user.setPassword(userDataVM.getPassword());
		user.setRole(userDataVM.getRole());
		user.setSignindate(userDataVM.getSignindate());
		user.setState(userDataVM.getState());
		user.setPosition(userDataVM.getPosition());
		user.setFirst_login(userDataVM.getFirst_login());
		
		return user;
	}
	
	public UserDataVM convert(User user){
		
		UserDataVM userDataVM = new UserDataVM();
		
		userDataVM.setBirthdate(user.getBirthdate());
		userDataVM.setCity(user.getCity());
		userDataVM.setConfirmcode(user.getConfirmcode());
		userDataVM.setConfirmed(user.getConfirmed());
		userDataVM.setCowntry(user.getCowntry());
		userDataVM.setEmail(user.getEmail());
		userDataVM.setId(user.getId());
		userDataVM.setName(user.getName());
		userDataVM.setPassword(user.getPassword());
		userDataVM.setRole(user.getRole());
		userDataVM.setSignindate(user.getSignindate());
		userDataVM.setState(user.getState());
		userDataVM.setPosition(user.getPosition());
		userDataVM.setFirst_login(user.getFirst_login());
		
		
		return userDataVM;
	}

}
