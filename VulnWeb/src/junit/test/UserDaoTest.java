package junit.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.eveino.dao.UserDao;
import com.eveino.dao.impl.UserDaoImpl;
import com.eveino.entity.User;
/***
 * 
 * @author 小王子
 *	用于测试
 */
public class UserDaoTest {
	//insert edit find test
	@Test
	public void testAdd() throws SQLException {
		/*
		 * String sql = "insert into user(id,username,password) values(?,?,?)";
		 * Object[] params = { 2, "bb", "bb" }; qr.update(sql, params);
		 */

		/*
		 * User user = new User(); user.setId(2); user.setUsername("eee");
		 * user.setPassword("deee"); editUser(user);
		 */
		/*
		 * User user = new User(); user = findUser(2);
		 * System.out.println(user.getId());
		 */

	}

	@Test
	public void getAllTest() throws SQLException {
		UserDao dao = new UserDaoImpl();
		List<User> list = new ArrayList<>();
		list = dao.getAll();
		for (User user : list) {
			System.out.println(user.getUsername());
		}
	}
	
}
