package pl.coderslab.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
    public static Connection getConn() throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/Library-rest-db?useSSL=false&characterEncoding=utf8&serverTimezone=UTC";
        String user = "root";
        String pass = "coderslab";
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, pass);
    }
}
