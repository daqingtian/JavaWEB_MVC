package dao.impl;

import dao.CustomerDao;
import domain.Customer;
import org.junit.Test;

import java.sql.PreparedStatement;
import java.util.List;

import static org.junit.Assert.*;

public class CustomerDaoJdbcImplTest {

    private CustomerDao customerDao  = new  CustomerDaoJdbcImpl();

    @Test
    public void getAll() {
        CustomerDaoJdbcImpl customerDaoJdbc = new CustomerDaoJdbcImpl();
        List<Customer> customers = customerDaoJdbc.getAll();
        for (Customer customer:customers){
            System.out.println(
            customer.getId()+"=="+
            customer.getAddress()+"=="+
            customer.getName()+"=="+
            customer.getPhone());
        }
    }

    @Test
    public void save() {
        CustomerDaoJdbcImpl customerDaoJdbc = new CustomerDaoJdbcImpl();
        Customer customer =new Customer();
        customer.setAddress("naddress");
        customer.setId(100);
        customer.setName("nname");
        customer.setPhone("nphone");
        customerDaoJdbc.save(customer);
    }

    @Test
    public void get() {
        Customer customer = customerDao.get(1);
        System.out.println(customer);
        System.out.println(
                customer.getId()+"=="+
                        customer.getAddress()+"=="+
                        customer.getName()+"=="+
                        customer.getPhone());
    }

    @Test
    public void delete() {
        CustomerDaoJdbcImpl customerDaoJdbc = new CustomerDaoJdbcImpl();
        customerDaoJdbc.delete(3);
    }

    @Test
    public void getCountWithName() {
        CustomerDaoJdbcImpl customerDaoJdbc = new CustomerDaoJdbcImpl();
        long count = customerDaoJdbc.getCountWithName("1name");
        System.out.println("数量："+count);
    }
}