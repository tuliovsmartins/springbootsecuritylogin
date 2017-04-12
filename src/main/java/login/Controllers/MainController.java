package login.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
	public String index(Model model) {
		return "index";
	}
	
	@RequestMapping("/login")
	public String userLogin(Model model) {
		return "index";
	}
	
	@RequestMapping("/panel")
	public String userPanel() {
		return "user/panel";
	}
	
}
