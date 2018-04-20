package junit.test;

import java.sql.SQLException;

import org.junit.Test;

import com.eveino.dao.UserDao;
import com.eveino.dao.impl.UserDaoImpl;
import com.eveino.entity.User;

public class UserTest {
	@Test
	public void findTest() throws SQLException{
		
		UserDao dao = new UserDaoImpl();
		User user = new User();
/*		user.setId(1111);
		user.setUsername("bbb");
		user.setPassword("bbb");*/

//		user = dao.findUser("bbb'");
		user = dao.findUser("bbb"+"'or 1=1#");
		//user = dao.findUser("bbb"+"' order by 4#");
		if(user!=null){
			System.out.println(user);
			System.out.println(user.getUsername());
		}
		else{
			System.out.println("haha");
		}
	}
}
