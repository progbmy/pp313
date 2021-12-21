package web.example.webpp312.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.example.webpp312.dao.UserDAO;
import web.example.webpp312.services.UserService;


import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

	private final UserService userService;

	public HomeController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {
		List<String> messages = new ArrayList<>();
		messages.add("Hello!");
		messages.add("This app MVC Security + database 2.4.2");
		messages.add("2021");
		model.addAttribute("messages", messages);
		return "index";
	}
	@GetMapping("/admin")
	public String adminPanel(Model model) {
		model.addAttribute("users", userService.resUsers());
		return "admin";
	}

}