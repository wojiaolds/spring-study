package thread.callable;

import LRU.User;

import java.util.concurrent.Callable;

import static java.lang.Thread.sleep;

/**
 * @Author: lds
 * @Date: 2019/8/1 14:30
 */
public class MyCallable implements Callable<User> {
	
	private String name;
	
	public MyCallable(String name){
		this.name = name;
	}
	
	@Override
	public User call () throws Exception {
		User user = new User ();
		user.setName (name);
		sleep(5000);
		return user;
	}
}
