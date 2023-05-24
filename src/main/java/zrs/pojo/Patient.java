package zrs.pojo;

import java.util.Date;

/**
 * 病人实体类
 * @author rsZheng
 */
public class Patient {
    private int id;
    private String name;
    private int age;
    private Date birthday;
    private double balance;
    private String address;

    public Patient() {
    }

    public Patient(int id, String name, int age, Date birthday, double balance, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.balance = balance;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", balance=" + balance +
                ", address='" + address + '\'' +
                '}';
    }
}
