package zrs.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 数据库连接池类
 * @author rsZheng
 */
public class DataSourceUtils {
    //1.私有构造方法
    private DataSourceUtils(){

    }

    //2.声明数据源变量
    private static DataSource dataSource;

    //3.提供静态代码块，完成配置文件的加载和获取数据库连接池对象
    static {
        try{
            //完成配置文件的加载
            InputStream is = DataSourceUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            Properties properties=new Properties();
            properties.load(is);

            //获取数据连接池对象
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //4.获取一个数据库的连接
    public static Connection getConnection(){
        Connection connection=null;
        try {
            connection=dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    //5.提供一个获取数据连接池对象的方法
    public static DataSource getDataSource(){
        return dataSource;
    }

    //6.提供释放资源的方法
    //查询释放资源的方法
    public static void close(Connection connection, Statement statement, ResultSet resultSet){
        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //增删改释放资源方法
    public static void close(Connection connection, Statement statement) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}