package zrs.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class ScalarHandler<T> implements ResultSetHandler<T> {

    //2.重写handler方法
    @Override
    public Long handler(ResultSet resultSet) {
        //3.定义一个Long类型变量
        Long value=null;
        try{
            //4.判断结果集对象是否还有数据
            if (resultSet.next()){
                //5.获取结果集源信息的对象
                ResultSetMetaData metaData=resultSet.getMetaData();
                //6.获取第一列的列明
                String columnName=metaData.getColumnName(1);
                //7.根据列名获取该列的值
                value=resultSet.getLong(columnName);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return value;
    }
}