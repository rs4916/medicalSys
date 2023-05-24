package zrs.dao;

import zrs.pojo.Doctor;
import zrs.util.BeanHandler;
import zrs.util.BeanListHandler;
import zrs.util.DataSourceUtils;
import zrs.util.JDBCTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rsZheng
 */
public class DoctorDao {
    private JDBCTemplate jdbcTemplate = new JDBCTemplate(DataSourceUtils.getDataSource());

    /**
     * 查询所有医生的列表
     * @return
     */
    public List<Doctor> queryAll(){
        String sql = "select * from doctor";
        List<Doctor> doctorList = jdbcTemplate.queryForList(sql,new BeanListHandler<>(Doctor.class));
        return doctorList;
    }

    /**
     * 根据id查询医生
     * @param id
     * @return
     */
    public Doctor getById(int id){
        String sql = "select * from doctor where id = ?";
        Doctor doctor = jdbcTemplate.queryForObject(sql,new BeanHandler<>(Doctor.class),id);
        return doctor;
    }

    /**
     * 添加医生信息
     * @param doctor
     * @return
     */
    public int addDoctor(Doctor doctor){
        String sql = "insert into doctor(name,age,birthday,seniority,post) values(?,?,?,?,?)";
        int i = jdbcTemplate.update(sql,doctor.getName(),doctor.getAge(),doctor.getBirthday(),doctor.getSeniority(),doctor.getPost());
        return i;
    }

    /**
     * 删除单个医生信息
     * @param id
     * @return
     */
    public int delete(int id){
        String sql = "delete from doctor where id = ?";
        int update = jdbcTemplate.update(sql,id);
        return update;
    }

    /**
     * 修改单个医生信息
     * @param doctor
     * @return
     */
    public int update(Doctor doctor){
        String sql = "update doctor set name = ?,age = ?,birthday = ?,seniority = ?,post = ? where id = ?";
        int i = jdbcTemplate.update(sql,doctor.getName(),doctor.getAge(),doctor.getBirthday(),doctor.getSeniority(),
                doctor.getPost(),doctor.getId());
        return i;
    }

    /**
     * 模糊查询医生姓名
     * @param name
     * @return
     */
    public List<Doctor> selectDoctor(String name){
        String sql = "select * from doctor where name like ?";
        // 设置通配符%
        // 1.拼接name参数，拼接成通配符的格式，并存进String列表中
        List<String> list = new ArrayList<>();
        list.add("%" + name + "%");
        // 2.将list列表转换为Object数组，因为Object是任何类的超类，不需要再做转换
        Object param[] = list.toArray();

        List<Doctor> doctorList = jdbcTemplate.queryForList(sql,new BeanListHandler<>(Doctor.class),param);
        return doctorList;
    }

    public static void main(String[] args) {
        /**
         * 测试模糊查询医生姓名
         */
        DoctorDao doctorDao = new DoctorDao();
        List<Doctor> doctorList = doctorDao.selectDoctor("李");
        for(Doctor doctor:doctorList){
            System.out.println(doctor);
        }
    }
}
