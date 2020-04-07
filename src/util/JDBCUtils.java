package util;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private static String url;
    private static String user;
    private static String password;
    private static String dirver;

    static{
        //读取资源文件，获取值
        try {
            //1.创建properties集合类
            Properties pro = new Properties();
            //2.获取src路径下的文件方式：Classloader 类加载器
            ClassLoader classloader = JDBCUtils.class.getClassLoader();
            URL res = classloader.getResource("jdbc.properties");
            String path = res.getPath();
            //3.加载文件
            pro.load(new FileReader(path));
            //4.获取数据，赋值
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            dirver = pro.getProperty("driver");
            //5.注册驱动
            Class.forName(dirver);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     * @return 连接对象
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }


    /**
     * 释放资源
     * @param ress
     * @param stat
     * @param conn
     */
    public static void close(ResultSet ress, Statement stat, Connection conn){
        if(ress != null){
            try {
                ress.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stat != null){
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Statement stat, Connection conn){
        if(stat != null){
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
