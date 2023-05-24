package zrs.service;

import zrs.dao.DoctorDao;
import zrs.pojo.Doctor;

import java.util.List;

/**
 * @author rsZheng
 */
public class DoctorService {
    DoctorDao doctorDao = new DoctorDao();

    /**
     * 查询所有医生的列表
     * @return
     */
    public List<Doctor> queryAll(){
        List<Doctor> doctorList = doctorDao.queryAll();
        return doctorList;
    }

    /**
     * 根据id查询医生
     * @param id
     * @return
     */
    public Doctor getById(int id){
        Doctor doctor = doctorDao.getById(id);
        return doctor;
    }

    /**
     * 添加医生信息
     * @param doctor
     * @return
     */
    public int addDoctor(Doctor doctor){
        int i = doctorDao.addDoctor(doctor);
        return  i;
    }

    /**
     * 删除单个医生信息
     * @param id
     * @return
     */
    public int delete(int id){
        int i = doctorDao.delete(id);
        return i;
    }

    /**
     * 修改单个医生信息
     * @param doctor
     * @return
     */
    public int update(Doctor doctor){
        int i = doctorDao.update(doctor);
        return i;
    }

    /**
     * 模糊查询医生姓名
     * @param name
     * @return
     */
    public List<Doctor> selectDoctor(String name){
        List<Doctor> doctorList = doctorDao.selectDoctor(name);
        return doctorList;
    }
}
