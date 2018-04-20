package com.eveino.service;

import java.sql.SQLException;

import com.eveino.entity.User;
import com.eveino.exception.UserExistEception;

public interface BusinessServer {

	void registerUser(User user) throws SQLException, UserExistEception;

	User loginUser(String username, String password) throws SQLException;

	void deleteUser();

	void updateUser();

}