package idat.edu.pe.daa2.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import idat.edu.pe.daa2.entity.User;
import idat.edu.pe.daa2.repository.UserRepositoty;

@Controller
public class AppController {

	@Autowired
	private UserRepositoty userRepo;
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		
		return "signup_form";
	}
	
	@PostMapping("/process_register")
	public String processRegister(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		userRepo.save(user);
		
		return "register_success";
	}
	
	@GetMapping("/users")
	public String showList(Model model) {
//		model.addAttribute("user", new User());
		List<User> listaUsuarios = userRepo.findAll();
		model.addAttribute("listaCategorias", listaUsuarios);
		return "users";
	}
}
