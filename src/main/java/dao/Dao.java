package dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.JdbcUtils;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author qiuyang
 * @date 2018-10-31 00:53
 * 封装了基本的CRUD的方法，以供子类继承使用
 * 当前DAO直接在方法中获取数据库连接
 * @param  <T> :当前DAO处理的实体的类型是什么
 */

public class Dao<T> {

    //DbUitl
    private QueryRunner queryRunner = new QueryRunner();

    //涉及到反射
    private Class<T> clazz;

    public Dao( ) {
        //反射部分薄弱
        Type superClass = getClass().getGenericSuperclass();
        if (superClass instanceof ParameterizedType){
            ParameterizedType parameterizedType= (ParameterizedType) superClass;
            Type[] typeArgs=parameterizedType.getActualTypeArguments();
            if (typeArgs!=null&&typeArgs.length>0){
                if (typeArgs[0] instanceof Class){
                    clazz= (Class<T>) typeArgs[0];
                }
            }
        }
    }

    /**
     * @param sql
     * @param args
     * 该方法封装了insert,delete,update 操作。
     * 整个DAO 采用DBUtiles解决方案。
     */
    public void update(String sql,Object...args){
        Connection connection =null;
        try {
            connection = JdbcUtils.getConnection();
            queryRunner.update(connection,sql,args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * @param sql
     * @param args
     * @return
     * 返回对应的T的一个实例的对象
     */
    public T get(String sql,Object...args){
//        System.out.println(clazz);
        Connection connection = null;
        try {
            connection = JdbcUtils.getConnection();
            return queryRunner.query(connection,sql,new BeanHandler<>(clazz),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * @param sql
     * @param args
     * @return
     * 返回T所对应的args
     */
    public List<T> getForList(String sql,Object...args){
        Connection connection = null;
        try {
            connection= JdbcUtils.getConnection();
            return  queryRunner.query(connection,sql,new BeanListHandler<>(clazz),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * @param sql
     * @param args
     * @param <E>
     * @return
     * 返回某一个字段的值：例如返回某一条记录的customername
     */
    public<E> E getForValue(String sql,Object...args){
        Connection connection = null;
        try {
            connection= JdbcUtils.getConnection();
            return (E) queryRunner.query(connection,sql,new ScalarHandler<>(),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
