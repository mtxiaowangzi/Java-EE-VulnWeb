package com.eveino.dao;

import java.sql.SQLException;
import java.util.List;

import com.eveino.entity.User;

public interface UserDao {

	void addUser(User user) throws SQLException;

	void deleteUser(String id) throws SQLException;

	List<User> getAll() throws SQLException;

	User findUser(String username) throws SQLException;

	User findUser(String username, String password) throws SQLException;

	void updateUser(User user) throws SQLException;

}