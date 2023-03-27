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
public class StudentDao extends BaseDao {


    public List<Student> queryAll() {
        List<Student> stuList = new ArrayList<Student>();
        try {
            this.getConnection();
            String sql = "select * from student";
            pre = con.prepareStatement(sql);
            re = pre.executeQuery();
            while (re.next()) {
                String id = re.getString("stu_id");
                String name = re.getString("stu_name");
                String cap = re.getString("stu_cap");
                String teacher = re.getString("stu_teacher");
                Student stu = new Student(id, name, cap, teacher);
                stuList.add(stu);
            }
            this.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stuList;
    }
}
