package taxi.project.sspringecurity.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import taxi.project.dao.AdminDao;
import taxi.project.model.Admin;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private AdminDao adminDao;
	
	// use for password encryption / encode..... PasswordEncoder is in-built interface
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Autowired
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
	
	// this method run before normal method & it is a part of bean lifecycle.
	@PostConstruct
	public void init() {
		long count = adminDao.count();
		if(count==0) {
			
			Admin admin = new Admin();
			admin.setUsername("Admin");
			admin.setPassword(passwordEncoder.encode("admin123"));
			
			adminDao.save(admin);
		}
	}
	
	@Override
	// loadUserByname internally spring will manage
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		// select sn,username,password from admin where username=?
		Optional<Admin> byUsername = adminDao.findByUsername(username);
		// check my submitted data is match with the data or not.
		 Admin admin = byUsername.orElseThrow(() -> new UsernameNotFoundException("ADMIN  Does Not Exist"));
		// match with submitted data
				 return User.withUsername(admin.getUsername()).password(admin.getPassword()).build();	
	}
}
