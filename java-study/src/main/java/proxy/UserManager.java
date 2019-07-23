package proxy;

/**
 * @Author: lds
 * @Date: 2019/7/23 10:55
 */
//用户管理接口
public interface UserManager {
	//新增用户抽象方法
	void addUser(String userName,String password);
	//删除用户抽象方法
	void delUser(String userName);
	
}
