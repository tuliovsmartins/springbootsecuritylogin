package login.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import login.Service.UserService;
import login.View.Model.UserDataVM;


@Controller
public class UserController {

	@Autowired
	UserService userService;
	

	@RequestMapping(value = "/getUserDetails", method = RequestMethod.POST)
	public Object getByEmail(Model model, String email, UserDataVM userDataVM) {
		
		return userDataVM;


	}
	

	@RequestMapping(value = "/panel", method = RequestMethod.GET)
	public String userPanel(Model model) {
		
		UserDataVM userDataVM = userService.getByEmail("tuliomartins@gmail.com");
		model.addAttribute("user", userDataVM);
		return "user/panel";
	}
	
}
