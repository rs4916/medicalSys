package zrs.service;

import zrs.dao.PatientDao;
import zrs.pojo.Patient;

import java.util.List;

public class PatientService {
    PatientDao patientDao = new PatientDao();

    /**
     * 查询所有病人信息
     * @return
     */
    public List<Patient> queryAll(){
        List<Patient> patientList = patientDao.queryAll();
        return patientList;
    }

    /**
     * 根据id查看病人信息
     * @param id
     * @return
     */
    public Patient query(int id){
        Patient query = patientDao.query(id);
        return query;
    }

    /**
     * 根据id修改病人信息
     * @param patient
     * @return
     */
    public int update(Patient patient){
        int update = patientDao.update(patient);
        return update;
    }

    /**
     * 根据id删除病人
     * @param id
     * @return
     */
    public int delete(int id){
        int delete = patientDao.delete(id);
        return delete;
    }

    /**
     * 添加病人信息
     * @param patient
     * @return
     */
    public int addPatient(Patient patient){
        int count=patientDao.addPatient(patient);
        return count;
    }

    /**
     * 模糊查询病人姓名
     * @param name
     * @return
     */
    public List<Patient> select(String name){
        List<Patient> patientList = patientDao.select(name);
        return patientList;
    }
}
