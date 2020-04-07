package dao;

import bean.User;
import util.JDBCUtils;

import java.sql.*;

public class UserDAO {

    /**
     * 登录功能
     * @param username
     * @param password
     * @return 用户对象 User
     */
    public User login(String username, String password){
        User u = null;
        Connection con = null;
        Statement sta = null;
        ResultSet res = null;
        try {
            //1.获取连接
            con = JDBCUtils.getConnection();
            //2.定义sql
            String sql = "select * from user where name = '"+username+"' and password = '"+password+"'";
            //3.获取执行sql的对象
            sta = con.createStatement();
            //4.执行查询
            res = sta.executeQuery(sql);
            //5.判断
            if(res.next()){
                u = new User();
                u.setName(res.getString("name"));
                u.setPassword(res.getString("password"));
                System.out.println("登录成功");
            } else{
                System.out.println("用户名或密码错误");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(res, sta, con);
        }
        return u;
    }

    /**
     * 注册功能
     * @param user
     * @return
     */
    public boolean register(User user){
        String username=  user.getName();
        String email = user.getEmail();
        String password = user.getPassword();
        Connection con = null;
        Statement sta = null;
        ResultSet res = null;
        try {
            con = JDBCUtils.getConnection();
            sta = con.createStatement();

            //判断输入是否合法
            if(username.length()==0 || password.length()==0){
                return false;
            }

            //判断用户名是否已存在
            String querySql = "select * from user where name = '"+username+"'";
            res = sta.executeQuery(querySql);
            if(res.next()){
                System.out.println("用户名已存在！");
                return false;
            }

            //添加新用户
            String insertSql = "insert into user (name,email,password) values " +
                    "('"+username+"','"+email+"','"+password+"')";
            sta.executeUpdate(insertSql);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(sta, con);
        }
        return true;
    }
}
