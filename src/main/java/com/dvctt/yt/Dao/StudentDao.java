package com.dvctt.yt.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dvctt.yt.entity.Student;

/**
 * @author etern
 */
public class StudentDao {
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql:///dsj02?serverTimezone=UTC";
    private String user = "root";
    private String password = "root";


    public List<Student> queryAll() {
        List<Student> stuList =new ArrayList<Student>();
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, password);
            String sql = "select * from student";
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet re = pre.executeQuery();
            while (re.next()) {
                String id = re.getString("stu_id");
                String name = re.getString("stu_name");
                String cap = re.getString("stu_cap");
                String teacher = re.getString("stu_teacher");
                Student stu = new Student(id, name, cap, teacher);
                stuList.add(stu);
            }
            re.close();
            pre.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stuList;
    }
}
