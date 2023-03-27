package com.dvctt.yt.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BaseDao {
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql:///dsj02?serverTimezone=UTC";
    private String user = "root";
    private String password = "root";

    Connection con;
    PreparedStatement pre;
    ResultSet re;

    public void getConnection() throws Exception {
        Class.forName(driver);
        con = DriverManager.getConnection(url, user, password);
    }

    public void close() throws Exception {
        if (re != null) {
            re.close();
        }
        if (pre != null) {
            pre.close();
        }
        if (con != null) {
            pre.close();
        }
    }
}
