package zrs.util;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * jdbc操作类
 * @author rsZheng
 */
public class JDBCTemplate {
    //1.定义参数变量(数据源，连接对象，执行者对象，结果集对象)
    private DataSource dataSource;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    //2.通过有参构造为数据源赋值
    public JDBCTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    //查询方法：用于将多条记录封装成自定义对象并返回
    public Long queryForScalar(String sql, ResultSetHandler<Long> resultSetHandler, Object...objects){
        Long value=null;

        try {
            //通过数据源获取一个数据库连接
            connection = dataSource.getConnection();

            //通过数据库连接对象获取执行者对象，并对sql语句进行预编译
            preparedStatement = connection.prepareStatement(sql);

            //通过执行者对象获取参数的源信息对象
            ParameterMetaData parameterMetaData = preparedStatement.getParameterMetaData();
            //通过参数源信息对象获取参数的个数
            int count = parameterMetaData.getParameterCount();

            //判断参数数量是否一致
            if (count != objects.length) {
                throw new RuntimeException("参数个数不匹配");
            }

            //为sql语句占位符赋值
            for (int i = 0; i < objects.length; i++) {
                preparedStatement.setObject(i + 1, objects[i]);
            }

            //执行sql语句并接收结果
            resultSet= preparedStatement.executeQuery();

            //通过BeanHandler方式对结果进行处理
            value=resultSetHandler.handler(resultSet);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //12.释放资源
            DataSourceUtils.close(connection, preparedStatement);
        }
        //返回结果
        return value;
    }

    //查询方法：用于将多条记录封装成自定义对象并返回
    public <T> List<T> queryForList(String sql, ResultSetHandler<T> resultSetHandler, Object...objects){
        List<T> list=new ArrayList<>();

        try {
            //通过数据源获取一个数据库连接
            connection = dataSource.getConnection();

            //通过数据库连接对象获取执行者对象，并对sql语句进行预编译
            preparedStatement = connection.prepareStatement(sql);

            //通过执行者对象获取参数的源信息对象
            ParameterMetaData parameterMetaData = preparedStatement.getParameterMetaData();
            //通过参数源信息对象获取参数的个数
            int count = parameterMetaData.getParameterCount();

            //判断参数数量是否一致
            if (count != objects.length) {
                throw new RuntimeException("参数个数不匹配");
            }

            //为sql语句占位符赋值
            for (int i = 0; i < objects.length; i++) {
                preparedStatement.setObject(i + 1, objects[i]);
            }

            //执行sql语句并接收结果
            resultSet= preparedStatement.executeQuery();

            //通过BeanHandler方式对结果进行处理
            list=resultSetHandler.handler(resultSet);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //12.释放资源
            DataSourceUtils.close(connection, preparedStatement);
        }
        //返回结果
        return list;
    }

    //查询方法：用于将一条记录封装成自定义对象并返回
    public <T> T queryForObject(String sql, ResultSetHandler<T> resultSetHandler,Object...objects){
        T obj=null;

        try {
            //通过数据源获取一个数据库连接
            connection = dataSource.getConnection();

            //通过数据库连接对象获取执行者对象，并对sql语句进行预编译
            preparedStatement = connection.prepareStatement(sql);

            //通过执行者对象获取参数的源信息对象
            ParameterMetaData parameterMetaData = preparedStatement.getParameterMetaData();
            //通过参数源信息对象获取参数的个数
            int count = parameterMetaData.getParameterCount();

            //判断参数数量是否一致
            if (count != objects.length) {
                throw new RuntimeException("参数个数不匹配");
            }

            //为sql语句占位符赋值
            for (int i = 0; i < objects.length; i++) {
                preparedStatement.setObject(i + 1, objects[i]);
            }

            //执行sql语句并接收结果
            resultSet= preparedStatement.executeQuery();

            //通过BeanHandler方式对结果进行处理
            obj=resultSetHandler.handler(resultSet);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //12.释放资源
            DataSourceUtils.close(connection, preparedStatement);
        }
        //返回结果
        return obj;
    }

    //3.定义update方法。参数:sql语句,sql语句中的参数
    public int update(String sql, Object... objects) {
        //4.定义int类型变量，用于接收增删改后影响的行数
        int result = 0;

        try {
            //5.通过数据源获取一个数据库连接
            connection = dataSource.getConnection();

            //6.通过数据库连接对象获取执行者对象，并对sql语句进行预编译
            preparedStatement = connection.prepareStatement(sql);

            //7.通过执行者对象获取参数的源信息对象
            ParameterMetaData parameterMetaData = preparedStatement.getParameterMetaData();
            //8.通过参数源信息对象获取参数的个数
            int count = parameterMetaData.getParameterCount();

            //9.判断参数数量是否一致
            if (count != objects.length) {
                throw new RuntimeException("参数个数不匹配");
            }

            //10.为sql语句占位符赋值
            for (int i = 0; i < objects.length; i++) {
                preparedStatement.setObject(i + 1, objects[i]);
            }

            //11.执行sql语句并接收结果
            result = preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //12.释放资源
            DataSourceUtils.close(connection, preparedStatement);
        }
        return result;
    }
}
