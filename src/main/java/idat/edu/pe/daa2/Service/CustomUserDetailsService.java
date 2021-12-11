package idat.edu.pe.daa2.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import idat.edu.pe.daa2.entity.User;
import idat.edu.pe.daa2.repository.UserRepositoty;

public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepositoty userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		User user = userRepo.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return new CustomUserDetails(user);
	}
}
