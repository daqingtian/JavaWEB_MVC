package service;

import dao.impl.CustomerDaoJdbcImpl;
import domain.CriteriaCustomer;
import domain.Customer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author qiuyang
 * @date 2018-11-02 02:36
 */
public class CustomerServlet extends HttpServlet {
    private static final long serializable = 1L;
    private CustomerDaoJdbcImpl customerDaoJdbc = new CustomerDaoJdbcImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String method = (String) req.getParameter("method");
//        switch (method){
//            case "add":
//                System.out.println("添加");
//                break;
//            case "query":
//                System.out.println("查询");
//                break;
//            case "delete":
//                System.out.println("删除");
//                break;
//        }

        String uri = req.getRequestURI();
        System.out.println(uri);
        uri =uri.substring(1,uri.length()-3);
        System.out.println(uri);
        try {
            //利用反射获取methodName对应的方法
            Method method = getClass().getDeclaredMethod(uri,HttpServletRequest.class,HttpServletResponse.class);
            //利用反射调用对应的方法
            method.invoke(this,req,resp);
        } catch (NoSuchMethodException e) {
            resp.sendRedirect("error.jsp");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**添加
     * @param req
     * @param resp
     */
    private void add(HttpServletRequest req,HttpServletResponse resp){
        String name = req.getParameter("name");
        String address =req.getParameter("address");
        String phone =  req.getParameter("phone");
        Customer customer = new Customer(name,address,phone);

        CustomerDaoJdbcImpl customerDaoJdbc = new CustomerDaoJdbcImpl();
        long nameCount = customerDaoJdbc.getCountWithName(name);
        if (nameCount>0){
            try {
                req.setAttribute("key","该用户名"+name+"已经被占用,请重新选择");
                req.getRequestDispatcher("addcustomer.jsp").forward(req,resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            customerDaoJdbc.save(customer);
            try {
                resp.sendRedirect("succesful.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        System.out.println("add");
    }

    /**
     * 查询
     * @param req
     * @param resp
     */
    private void query(HttpServletRequest req,HttpServletResponse resp){
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        CriteriaCustomer criteriaCustomer = new CriteriaCustomer(name,address,phone);
        List<Customer> customers = customerDaoJdbc.getForListWithCriteriaCustomer(criteriaCustomer);
        req.setAttribute("customers",customers);
        try {
            req.getRequestDispatcher("customer.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println("query");
    }

    /**
     * 删除
     * @param req
     * @param resp
     */
    private void delete(HttpServletRequest req,HttpServletResponse resp){
        Integer id = Integer.parseInt(req.getParameter("id"));
        CustomerDaoJdbcImpl customerDaoJdbc = new CustomerDaoJdbcImpl();
        customerDaoJdbc.delete(id);
        try {
            resp.sendRedirect("query.do");
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println("delete");
    }

    private void edit (HttpServletRequest req,HttpServletResponse resp){
        Integer id = Integer.parseInt(req.getParameter("id"));
        Customer customer = customerDaoJdbc.get(id);
        req.setAttribute("customer",customer);
        try {
            req.getRequestDispatcher("edit.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void update(HttpServletRequest req,HttpServletResponse resp){
        Integer id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        Customer customer = new Customer(id,name,address,phone);
        customerDaoJdbc.update(customer);
        try {
            resp.sendRedirect("succesful.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
