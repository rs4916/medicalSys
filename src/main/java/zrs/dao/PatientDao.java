package zrs.dao;

import zrs.pojo.Patient;
import zrs.util.BeanHandler;
import zrs.util.BeanListHandler;
import zrs.util.DataSourceUtils;
import zrs.util.JDBCTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rsZheng
 */
public class PatientDao {
    private JDBCTemplate jdbcTemplate = new JDBCTemplate(DataSourceUtils.getDataSource());

    /**
     * 查询所有病人信息
     * @return
     */
    public List<Patient> queryAll(){
        String sql = "select * from patient";
        List<Patient> patientList = jdbcTemplate.queryForList(sql,new BeanListHandler<>(Patient.class));
        return patientList;
    }

    /**
     * 根据id查看病人信息
     * @param id
     * @return
     */
    public Patient query(int id){
        String sql="select * from patient where id = ?";
        Patient patient = jdbcTemplate.queryForObject(sql,new BeanHandler<>(Patient.class),id);
        return patient;
    }

    /**
     * 根据id修改病人信息
     * @param patient
     * @return
     */
    public int update(Patient patient){
        String sql="update patient set name = ?,age = ?,birthday = ?,balance = ?,address = ? where id = ?";
        int count = jdbcTemplate.update(sql,patient.getName(),patient.getAge(),patient.getBirthday(),patient.getBalance(), patient.getAddress(),patient.getId());
        return count;
    }

    /**
     * 根据id删除病人
     * @param id
     * @return
     */
    public int delete(int id){
        String sql = "delete from patient where id = ?";
        int count = jdbcTemplate.update(sql,id);
        return count;
    }

    /**
     * 添加病人信息
     * @param patient
     * @return
     */
    public int addPatient(Patient patient){
        String sql="insert into patient (name,age,birthday,balance,address) values(?,?,?,?,?)";
        int count = jdbcTemplate.update(sql,patient.getName(),patient.getAge(),patient.getBirthday(),patient.getBalance(),patient.getAddress());
        return count;
    }

    /**
     * 模糊查询病人姓名
     * @param name
     * @return
     */
    public List<Patient> select(String name){
        String sql="select * from patient where name like ?";
        // 设置通配符%
        // 1.拼接name参数，拼接成通配符的格式，并存进String列表中
        List<String> list=new ArrayList<>();
        list.add("%" + name + "%");
        // 2.将list列表转换为Object数组，因为Object是任何类的超类，不需要再做转换
        Object param[] = list.toArray();
        List<Patient> patientList = jdbcTemplate.queryForList(sql,new BeanListHandler<>(Patient.class),param);
        return patientList;
    }
}
