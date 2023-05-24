package zrs.service;

import zrs.dao.UserDao;
import zrs.pojo.User;

/**
 * @author rsZheng
 */
public class UserService {
    UserDao userDao = new UserDao();

    /**
     * 查询用户账号和密码是否存在
     * @param username 用户名
     * @param password 密码
     * @return
     */
    public User query(String username,String password){
        User user = userDao.query(username,password);
        System.out.println("service:" + user);
        return user;
    }
}