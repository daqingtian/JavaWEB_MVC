package dao;

import domain.CriteriaCustomer;
import domain.Customer;

import javax.swing.undo.CannotUndoException;
import java.util.List;

/**
 * @author qiuyang
 * @date 2018-10-31 01:19
 */
public interface CustomerDao {

    public List<Customer> getAll();
    public void save (Customer customer);
    public Customer get(Integer id);
    public void delete(Integer id);
    public void update(Customer customer);


    /**
     * 模糊查询
     */
    public List<Customer> getForListWithCriteriaCustomer(CriteriaCustomer criteriaCustomer);


    /**
     * @param key
     * @return
     * 模糊查询
     */
//    public List<Customer> frzzyQuery(String key);
//    public List<Customer> frzzyQuery();

    /**
     * @param name
     * @return
     * 返回和name 相等的记录数
     */
    public long getCountWithName(String name);

}
