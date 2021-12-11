package idat.edu.pe.daa2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import idat.edu.pe.daa2.entity.User;

public interface UserRepositoty extends JpaRepository<User, Integer>{
	
	@Query("SELECT u FROM User u WHERE u.email = ?1")
	public User findByEmail(String email);

}
