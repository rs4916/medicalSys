package zrs.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

//1.定义一个类，实现ResultSetHandler接口
public class BeanListHandler<T> implements ResultSetHandler<T> {
    //2.定义Class对象类型变量
    private Class<T> beanClass;

    //3.通过有参构造为变量赋值
    public BeanListHandler(Class<T> beanClass){
        this.beanClass=beanClass;
    }
    //4.重写handler方法，用于将多条记录封装到自定义对象中
    @Override
    public List<T> handler(ResultSet resultSet) {
        //5.声明集合对象类型
        List<T> list=new ArrayList<>();
        try {
            //6.判断结果集中是否有数据
            while (resultSet.next()){
                //7.创建结果集中是否有数据
                T bean=beanClass.newInstance();
                //8.通过结果集对象获取结果集源信息的对象
                ResultSetMetaData metaData=resultSet.getMetaData();
                //9.通过结果集源信息对象获取列数
                int count=metaData.getColumnCount();
                //10.通过循环遍历列数
                for (int i=1;i<=count;i++){
                    //11.通过结果集源信息对象获取列名
                    String columnName=metaData.getColumnName(i);
                    //12.通过列明获取该列的数据
                    Object value=resultSet.getObject(columnName);
                    //13.创建属性描述器对象，将获取到的值通过改对象的set方法进行赋值
                    PropertyDescriptor pd=new PropertyDescriptor(columnName.toLowerCase(),beanClass);
                    //获取set方法
                    Method writeMethod=pd.getWriteMethod();
                    //执行set方法，给成员变量赋值
                    writeMethod.invoke(bean,value);
                }
                //将对象保存到集合中
                list.add(bean);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}