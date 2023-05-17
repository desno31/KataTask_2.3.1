package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/users")
public class HelloController {

	@Autowired
	private UserService userService;

	@GetMapping
	public String index(Model model) {
		model.addAttribute("users", userService.index());
		return "index";
	}

	@GetMapping(value = "/new")
	public String newUser(@ModelAttribute("user") User user) {
		return "new";
	}

	@PostMapping
	public String create(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "new";
		}
		userService.save(user);
		return "redirect:/users";
	}

	@GetMapping("/{id}/edit")
	public String edit(Model model, @PathVariable("id") int id) {
		model.addAttribute("user", userService.getById(id));
		return "edit";
	}

	@PatchMapping("/{id}")
	public String update(@ModelAttribute("user") @Valid User user,
						 BindingResult bindingResult, @PathVariable("id") int id) {
		if (bindingResult.hasErrors()) {
			return "edit";
		}
		userService.edit(user);
		return "redirect:/users";
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") int id) {
		userService.deleteById(id);
		return "redirect:/users";
	}
}