package zrs.dao;

import zrs.pojo.User;
import zrs.util.BeanHandler;
import zrs.util.DataSourceUtils;
import zrs.util.JDBCTemplate;

/**
 * @author rsZheng
 */
public class UserDao {
    // 获取一个数据源
    private JDBCTemplate jdbcTemplate = new JDBCTemplate(DataSourceUtils.getDataSource());

    /**
     * 查询用户账号和密码是否存在
     * @param
     * @param
     * @return
     */
    public User query(String username, String password){
        String sql = "select * from user where username = ? and password = ?";
        User user = jdbcTemplate.queryForObject(sql,new BeanHandler<>(User.class),username,password);
        System.out.println(user);
        return user;
    }

    /**
     * 根据id查询管理员
     * @param id
     * @return
     */
    public User getById(int id){
        String sql = "select * from user where id = ?";
        User user = jdbcTemplate.queryForObject(sql,new BeanHandler<>(User.class),id);
        return user;
    }
}