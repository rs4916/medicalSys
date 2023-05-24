package zrs.pojo;

import java.util.Date;

/**
 * 药品实体类
 * @author rsZheng
 */
public class Medicine {
    private int id;
    private String name;
    private String function;
    private Date date_of_manufacture;
    private String address;
    private String taboo;
    private double price;

    public Medicine() {
    }

    public Medicine(int id, String name, String function, Date date_of_manufacture, String address, String taboo, double price) {
        this.id = id;
        this.name = name;
        this.function = function;
        this.date_of_manufacture = date_of_manufacture;
        this.address = address;
        this.taboo = taboo;
        this.price = price;
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

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public Date getDate_of_manufacture() {
        return date_of_manufacture;
    }

    public void setDate_of_manufacture(Date date_of_manufacture) {
        this.date_of_manufacture = date_of_manufacture;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTaboo() {
        return taboo;
    }

    public void setTaboo(String taboo) {
        this.taboo = taboo;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", function='" + function + '\'' +
                ", date_of_manufacture=" + date_of_manufacture +
                ", address='" + address + '\'' +
                ", taboo='" + taboo + '\'' +
                ", price=" + price +
                '}';
    }
}
