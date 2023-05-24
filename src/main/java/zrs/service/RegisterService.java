package zrs.service;

import zrs.dao.*;
import zrs.pojo.*;

import java.util.List;

/**
 * @author rsZheng
 */
public class RegisterService {
    RegisterDao registerDao = new RegisterDao();
    DoctorDao doctorDao = new DoctorDao();
    MedicineDao medicineDao = new MedicineDao();
    PatientDao patientDao = new PatientDao();
    UserDao userDao = new UserDao();

    /**
     * 挂号功能
     * @param register
     * @return
     */
    public int addRegister(Register register){
        int i = registerDao.addRegister(register);
        return i;
    }

    /**
     * 查询全部病历
     * @return
     */
    public List<Register> queryAll(){
        List<Register> registerList = registerDao.queryAll();

        for (Register register : registerList) {
            // 医生id
            Doctor doctor = doctorDao.getById(register.getDid());
            // 药品id
            Medicine medicine = medicineDao.query(register.getMid());
            // 病人id
            Patient patient = patientDao.query(register.getPid());
            // 用户id
            User user = userDao.getById(register.getUid());

            register.setDoctor(doctor);
            register.setUser(user);
            register.setMedicine(medicine);
            register.setPatient(patient);
        }
        return registerList;
    }

    /**
     * 根据病人id查询其未付款列表
     * @param pid
     * @return
     */
    public List<Register> findNoPayListByPId(int pid){
        List<Register> registerList = registerDao.findNoPayListByPId(pid);

        for (Register register : registerList) {
            Doctor doctor = doctorDao.getById(register.getDid());
            Medicine medicine = medicineDao.query(register.getMid());
            Patient patient = patientDao.query(register.getPid());
            User user = userDao.getById(register.getUid());

            register.setDoctor(doctor);
            register.setUser(user);
            register.setMedicine(medicine);
            register.setPatient(patient);
        }
        return registerList;
    }

    /**
     * 支付所有费用
     * @param id
     * @return
     */
    public int payAllCost(int id){
        // 医生挂号费
        long doctor = registerDao.getDoctor(id);
        // 药费
        long medicine = registerDao.getMedicineSum(id);
        // 总费用 = 挂号费 + 药费
        long sum = doctor + medicine;
        /**
         * 扣费后更新病人余额
         * 该方法内部SQL实现是set balance = balance - sum
         * @param sum 病人花费
         * @param id 病人id
         */
        int balance = registerDao.updateBalance(sum, id);
        // 更新病人订单状态
        int i = registerDao.updateIs_payment(id);
        return balance + i;
    }

    public static void main(String[] args) {
        /**
         * 测试查询全部病历
         */
        RegisterService registerService = new RegisterService();
        List<Register> registerList = registerService.queryAll();
        for(Register register : registerList){
            System.out.println(register);
        }
    }
}
