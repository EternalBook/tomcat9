package com.dvctt.yt.Dao;

import com.dvctt.yt.entity.Admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author etern
 */
public class AdminDao extends BaseDao {

    public Admin queryById(String id) {
        Admin admin = null;
        try {
            this.getConnection();
            String sql = "select * from admin where admin_id = ?";
            pre = con.prepareStatement(sql);
            pre.setString(1, id);
            re = pre.executeQuery();
            while (re.next()) {
                String name = re.getString("admin_name");
                String pass = re.getString("admin_pass");
                admin = new Admin(id, name, pass);
            }
            this.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return admin;
    }

    public static void main(String[] args) {
        AdminDao ad = new AdminDao();
        Admin admin = ad.queryById("abc");
        if (admin != null) {
            System.out.println(admin.getName());
        } else {
            System.out.println("没有该用户");

        }
    }
}
