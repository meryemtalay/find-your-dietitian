package com.proje.diyetisyeninibul.restapi;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.proje.diyetisyeninibul.entities.Login;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String loginForm(Model model) {
		model.addAttribute("login", new Login());
		return "login";
	}

	@PostMapping("/login")
	public String loginSubmit(@Valid Login login, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "login";
		}
		return "redirect:/select";
	}

}
