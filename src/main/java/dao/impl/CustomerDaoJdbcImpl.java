package dao.impl;

import dao.CustomerDao;
import dao.Dao;
import domain.CriteriaCustomer;
import domain.Customer;
import java.util.List;

/**
 * @author qiuyang
 * @date 2018-10-31 01:26
 */
public class CustomerDaoJdbcImpl extends Dao<Customer> implements CustomerDao {

    /**
     * @return
     * 获取所有的Customer
     */
    @Override
    public List<Customer> getAll() {
        String sql = "select id,name,address,phone from customer";
        return getForList(sql);
    }

    /**
     * @param customer
     * 保存custormer
     */
    @Override
    public void save(Customer customer) {
        String sql = "insert into customer(name,address,phone) values(?,?,?)";
        update(sql,customer.getName(),customer.getAddress(),customer.getPhone());
    }

    /**
     * @param id
     * @return
     * 通过Id 获取Customer
     */
    @Override
    public Customer get(Integer id) {
//        Customer res = get(null, null);
        String sql = "select id,name,address,phone from customer where id = ?";
        return get(sql,id);
    }

    /**
     * @param id
     * 通过ID删除Customer
     */
    @Override
    public void delete(Integer id) {
        String sql = "delete from customer where id =?";
        update(sql,id);
    }

    @Override
    public void update(Customer customer) {
        String sql = "update customer set name=?,address=?,phone=? where id =?";
        update(sql,customer.getName(),customer.getAddress(),customer.getPhone(),customer.getId());
    }

    /**
     * @param name
     * @return
     * 通过name查询数据库中有几条name为name的数据，返回条数
     */
    @Override
    public long getCountWithName(String name) {
        String sql = "select count(id) from customer where name = ?";
        return getForValue(sql,name);
    }


    /**
     * 模糊查询
     */
    @Override
    public List<Customer> getForListWithCriteriaCustomer(CriteriaCustomer criteriaCustomer){
        String sql = "select id, name,address,phone from customer where name like ? and address like ?" +
                "and phone like ? ";
        return getForList(sql,criteriaCustomer.getName(),criteriaCustomer.getAddress(),criteriaCustomer.getPhone());
    }





//    /**
//     * @return
//     * 模糊查询
//     */
//    @Override
//    public List<Customer> frzzyQuery(String key) {
//        String sql = "select id,name,address,phone from customer where name like ?";
//        return getForList(sql,key);
//    }

//    @Override
//    public List<Customer> frzzyQuery() {
//        return null;
//    }


}
