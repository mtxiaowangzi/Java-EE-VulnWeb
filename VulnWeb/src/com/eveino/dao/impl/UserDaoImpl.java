package com.eveino.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.eveino.dao.UserDao;
import com.eveino.entity.User;
import com.eveino.utils.JdbcUtils;

public class UserDaoImpl implements UserDao {
	private QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eveino.dao.UserDao#addUser(com.eveino.entity.User)
	 */
	@Override
	public void addUser(User user) throws SQLException {
		String sql = "insert into user(id,username,password) values(?,?,?)";
		Object[] params = { user.getId(), user.getUsername(), user.getPassword() };
		qr.update(sql, params);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eveino.dao.UserDao#deleteUser(java.lang.String)
	 */
	@Override
	public void deleteUser(String id) throws SQLException {
		String sql = "delete from user where id=?";
		Object[] params = { id };
		qr.update(sql, params);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eveino.dao.UserDao#editUser(com.eveino.entity.User)
	 */
	@Override
	public void updateUser(User user) throws SQLException {
		String sql = "update user set username=?,password=? where id=?";
		Object[] params = { user.getUsername(), user.getPassword(), user.getId() };
		qr.update(sql, params);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eveino.dao.UserDao#findUser(int)
	 */
/*	@Override
	public User findUser(String username) throws SQLException {
		String sql = "select id,username,password from user where username=?";
		Object[] params = { username };
		User user = qr.query(sql, new BeanHandler<User>(User.class), params);
		return user;
	}*/
	
	//sqli vul Demo
	@Override
	public User findUser(String username) throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		String sql = "select id,username,password from user where username="+"'"+username+"'";
		Statement st = conn.createStatement();
		ResultSet rs= st.executeQuery(sql);
		if(rs.next()){
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setPassword(rs.getString("password"));
			user.setUsername(rs.getString("username"));
			return user;
		}
		conn.close();
		return null;
	}

	@Override
	public User findUser(String username, String password) throws SQLException {
		String sql = "select id,username,password from user where username=? and password =?";
		Object[] params = { username, password };
		User user = qr.query(sql, new BeanHandler<User>(User.class), params);
		return user;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eveino.dao.UserDao#getAll()
	 */
	@Override
	public List<User> getAll() throws SQLException {
		String sql = "select id,username,password from user";
		List<User> list = qr.query(sql, new BeanListHandler<User>(User.class));
		return list;
	}

}
