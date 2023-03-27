package com.dvctt.yt.tomcat9;

import com.dvctt.yt.Dao.StudentDao;
import com.dvctt.yt.entity.Student;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author etern
 */
@WebServlet(name = "Servlet", value = "/Servlet")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //1.加入从数据库查询到了学生的信息
//        Student stu = new Student("123", "小王", "21大数据02", "蔡老师");
//        JSONObject jsonObject = JSONObject.fromObject(stu);
        //查询数据库的数据
        StudentDao sd = new StudentDao();
        List<Student> stuList = sd.queryAll();
        JSONArray jsonArray = JSONArray.fromObject(stuList);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(jsonArray.toString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
