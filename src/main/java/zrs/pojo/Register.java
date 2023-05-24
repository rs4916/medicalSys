package zrs.pojo;

import zrs.pojo.Doctor;
import zrs.pojo.Medicine;
import zrs.pojo.Patient;
import zrs.pojo.User;

import java.util.Date;

/**
 * 病历实体类
 * @author rsZheng
 */
public class Register {
    private int id;
    private int pid;
    private int did;
    private int mid;
    private int uid;
    private Date creation_time;
    private String is_payment;
    private Doctor doctor;
    private Medicine medicine;
    private Patient patient;
    private User user;

    public Register() {
    }

    public Register(int id, int pid, int did, int mid, int uid, Date creation_time, String is_payment, Doctor doctor, Medicine medicine, Patient patient, User user) {
        this.id = id;
        this.pid = pid;
        this.did = did;
        this.mid = mid;
        this.uid = uid;
        this.creation_time = creation_time;
        this.is_payment = is_payment;
        this.doctor = doctor;
        this.medicine = medicine;
        this.patient = patient;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Date getCreation_time() {
        return creation_time;
    }

    public void setCreation_time(Date creation_time) {
        this.creation_time = creation_time;
    }

    public String getIs_payment() {
        return is_payment;
    }

    public void setIs_payment(String is_payment) {
        this.is_payment = is_payment;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Register{" +
                "id=" + id +
                ", pid=" + pid +
                ", did=" + did +
                ", mid=" + mid +
                ", uid=" + uid +
                ", creation_time=" + creation_time +
                ", is_payment='" + is_payment + '\'' +
                ", doctor=" + doctor +
                ", medicine=" + medicine +
                ", patient=" + patient +
                ", user=" + user +
                '}';
    }
}