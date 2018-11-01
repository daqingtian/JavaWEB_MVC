package dao.impl;

import dao.CustomerDao;
import dao.Dao;
import domain.Customer;
import java.util.List;

/**
 * @author qiuyang
 * @date 2018-10-31 01:26
 */
public class CustomerDaoJdbcImpl extends Dao<Customer> implements CustomerDao {
    @Override
    public List<Customer> getAll() {
        String sql = "select id,name,address,phone from customer";
        return getForList(sql);
    }

    @Override
    public void save(Customer customer) {
        String sql = "insert into customer(name,address,phone) values(?,?,?)";
        update(sql,customer.getName(),customer.getAddress(),customer.getPhone());
    }

    @Override
    public Customer get(Integer id) {
//        Customer res = get(null, null);
        String sql = "select id,name,address,phone from customer where id = ?";
        return get(sql,id);
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from customer where id =?";
        update(sql,id);
    }

    @Override
    public long getCountWithName(String name) {
        String sql = "select count(id) from customer where name = ?";
        return getForValue(sql,name);
    }
}
