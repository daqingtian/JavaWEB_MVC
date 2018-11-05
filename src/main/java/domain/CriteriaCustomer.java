package domain;

/**
 * @author qiuyang
 * @date 2018-11-03 22:58
 * 为Customer模糊查询提供的类
 */
public class CriteriaCustomer {
    private String name;
    private String address;
    private  String phone;

    public CriteriaCustomer() {
    }

    public CriteriaCustomer(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        if (this.name==null){
            this.name = "%%";
        }else {
            this.name = "%"+this.name+"%";
        }
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        if (this.address==null){
            this.address = "%%";
        }else {
            this.address = "%"+this.address+"%";
        }
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        if (this.phone==null){
            this.phone = "%%";
        }else {
            this.phone = "%"+this.phone+"%";
        }
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
