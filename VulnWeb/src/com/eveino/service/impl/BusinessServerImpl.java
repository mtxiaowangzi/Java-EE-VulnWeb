package com.eveino.service.impl;

import java.sql.SQLException;


import com.eveino.dao.UserDao;
import com.eveino.dao.impl.UserDaoImpl;
import com.eveino.entity.User;
import com.eveino.exception.UserExistEception;
import com.eveino.service.BusinessServer;

public class BusinessServerImpl implements BusinessServer {
	private UserDao dao = new UserDaoImpl();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.eveino.service.BusinessServerImpl#registerUser(com.eveino.entity.
	 * User)
	 */
	@Override
	public void registerUser(User user) throws SQLException, UserExistEception {
		if (dao.findUser(user.getUsername()) != null) {
			throw new UserExistEception("用户已存在");
		}
		dao.addUser(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eveino.service.BusinessServerImpl#loginUser(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public User loginUser(String username, String password) throws SQLException {
		return dao.findUser(username, password);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eveino.service.BusinessServerImpl#deleteUser()
	 */
	@Override
	public void deleteUser() {
		// TODO
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eveino.service.BusinessServerImpl#updateUser()
	 */
	@Override
	public void updateUser() {
		// TODO
	}
}
