package au.usyd.elec5619.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import au.usyd.elec5619.dao.LoginDao;
import au.usyd.elec5619.domain.UserRole;
import au.usyd.elec5619.domain.User;

//import com.beingjavaguys.dao.login.LoginDao;
//import com.beingjavaguys.models.login.UserRole;
//import com.beingjavaguys.models.login.Users;

@Service("loginService")
public class LoginService implements UserDetailsService {

	@Autowired
	LoginDao loginDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = loginDao.findByUserName(username);

		List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRole());

		return buildUserForAuthentication(user, authorities);
	}

	private org.springframework.security.core.userdetails.User buildUserForAuthentication(User user,
			List<GrantedAuthority> authorities) {
		// return new
		// org.springframework.security.core.userdetails.User(user.getUsername(),
		// user.getPassword(),
		// user.isEnabled(), true, true, true, authorities);
		return new LoggedUserDetails(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true,
				authorities, user);
	}

	private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		// Build user's authorities
		// for (UserRole userRole : userRoles) {
		// setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
		// }
		//
		// List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(
		// setAuths);

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>();
		Result.add(new SimpleGrantedAuthority("ROLE_USER"));
		Result.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

		return Result;
	}

}
