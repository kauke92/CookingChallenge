package au.usyd.elec5619.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import au.usyd.elec5619.domain.User;

public class LoggedUserDetails extends org.springframework.security.core.userdetails.User{
	private User user;
	public LoggedUserDetails(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities, User user) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
	
	

}
