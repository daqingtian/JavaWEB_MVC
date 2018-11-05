package domain;

/**
 * @author qiuyang
 * @date 2018-10-31 01:20
 */
public class Customer {

    //            | Field   | Type        | Null | Key | Default | Extra          |
//            +---------+-------------+------+-----+---------+----------------+
//            | id      | int(11)     | NO   | PRI | NULL    | auto_increment |
//            | name    | varchar(30) | YES  | UNI | NULL    |                |
//            | address | varchar(30) | YES  |     | NULL    |                |
//            | phone   | varchar(30) | YES  |     | NULL    |
    private int id;
    private String name;
    private String address;
    private  String phone;

    public Customer() {
    }

    public Customer(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public Customer(int id, String name, String address, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
