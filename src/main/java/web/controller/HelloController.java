package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web.dao.UserDaoImpl;
import web.model.User;

@Controller
public class HelloController {

	UserDaoImpl userDao = new UserDaoImpl();

	@GetMapping(value = "/")
	public String index(Model model) {
		model.addAttribute("users", userDao.index());
		return "index";
	}

	/*@GetMapping(value = "/cars")
	public String printCarsList(@RequestParam(value = "count", required = false) Integer count, Model model) {
		model.addAttribute("carsList", getCarList(count));
		return "cars";
	}*/
	
}