package au.usyd.elec5619.dao;

import au.usyd.elec5619.domain.User;

public interface LoginDao {
	User findByUserName(String username);
}
