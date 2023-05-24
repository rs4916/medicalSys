package zrs.pojo;

import java.util.Date;

/**
 * 医生实体类
 * @author rsZheng
 */
public class Doctor {
    private int id;
    private String name;
    private int age;
    private Date birthday;
    private int seniority;
    private String post;

    public Doctor(){

    }

    public Doctor(int id, String name, int age, Date birthday, int seniority, String post) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.seniority = seniority;
        this.post = post;
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

    public int getSeniority() {
        return seniority;
    }

    public void setSeniority(int seniority) {
        this.seniority = seniority;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", seniority=" + seniority +
                ", post='" + post + '\'' +
                '}';
    }
}