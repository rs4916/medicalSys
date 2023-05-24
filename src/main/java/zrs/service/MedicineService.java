package zrs.service;

import zrs.dao.MedicineDao;
import zrs.pojo.Medicine;

import java.util.List;

/**
 * @author rsZheng
 */
public class MedicineService {
    MedicineDao medicineDao = new MedicineDao();

    /**
     * 查询所有药品信息
     * @return
     */
    public List<Medicine> queryAll(){
        List<Medicine> medicineList = medicineDao.queryAll();
        return medicineList;
    }

    /**
     * 根据id查看药品信息
     * @param id
     * @return
     */
    public Medicine query(int id){
        Medicine medicine  = medicineDao.query(id);
        return medicine;
    }

    /**
     * 添加药品
     * @param medicine
     * @return
     */
    public int addMedicine(Medicine medicine){
        int i = medicineDao.addMedicine(medicine);
        return i;
    }

    /**
     * 根据id删除药品
     * @param id
     * @return
     */
    public int delete(int id){
        int i=medicineDao.delete(id);
        return i;
    }

    /**
     * 根据id修改药品信息
     * @param medicine
     * @return
     */
    public int update(Medicine medicine){
        int update = medicineDao.update(medicine);
        return update;
    }

    /**
     * 模糊查询药品名字
     * @param name
     * @return
     */
    public List<Medicine> select(String name){
        List<Medicine> medicines = medicineDao.select(name);
        return medicines;
    }
}