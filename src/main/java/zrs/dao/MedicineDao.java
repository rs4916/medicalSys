package zrs.dao;

import zrs.pojo.Medicine;
import zrs.util.BeanHandler;
import zrs.util.BeanListHandler;
import zrs.util.DataSourceUtils;
import zrs.util.JDBCTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rsZheng
 */
public class MedicineDao {
    private JDBCTemplate jdbcTemplate = new JDBCTemplate(DataSourceUtils.getDataSource());

    /**
     * 查询所有药品
     * @return
     */
    public List<Medicine> queryAll(){
        String sql = "select * from medicine";
        List<Medicine> medicineList = jdbcTemplate.queryForList(sql,new BeanListHandler<>(Medicine.class));
        return medicineList;
    }

    /**
     * 根据id查看药品信息
     * @param id
     * @return
     */
    public Medicine query(int id){
        String sql="select * from medicine where id=?";
        Medicine medicine = jdbcTemplate.queryForObject(sql, new BeanHandler<>(Medicine.class), id);
        return medicine;
    }

    /**
     * 添加药品
     * @param medicine
     * @return
     */
    public int addMedicine(Medicine medicine){
        String sql="INSERT INTO medicine (name,function,date_of_manufacture,address,taboo,price) VALUES (?,?,?,?,?,?)";
        int update = jdbcTemplate.update(sql,medicine.getName(),medicine.getFunction(),medicine.getDate_of_manufacture(),
                medicine.getAddress(),medicine.getTaboo(),medicine.getPrice());
        return update;
    }

    /**
     * 根据id删除药品
     * @param id
     * @return
     */
    public int delete(int id){
        String sql="delete from medicine where id=?  ";
        int update = jdbcTemplate.update(sql, id);
        return update;
    }

    /**
     * 根据id查询药品信息
     * @param medicine
     * @return
     */
    public int update(Medicine medicine){
        String sql="UPDATE medicine set name = ?,function = ?,date_of_manufacture = ?,address = ?,taboo = ?,price = ? where id = ?";
        int update = jdbcTemplate.update(sql,medicine.getName(),medicine.getFunction(),medicine.getDate_of_manufacture(),
                medicine.getAddress(),medicine.getTaboo(),medicine.getPrice(),medicine.getId());
        return update;
    }

    /**
     * 模糊查询药品名字
     * @param name
     * @return
     */
    public List<Medicine> select(String name){
        String sql="select * from medicine where name like ?";
        // 设置通配符%
        // 1.拼接name参数，拼接成通配符的格式，并存进String列表中
        List<String > list=new ArrayList<>();
        list.add("%" + name + "%");
        // 2.将list列表转换为Object数组，因为Object是任何类的超类，不需要再做转换
        Object param[]=list.toArray();

        List<Medicine> medicineList = jdbcTemplate.queryForList(sql,new BeanListHandler<>(Medicine.class),param);
        return medicineList;
    }
}
