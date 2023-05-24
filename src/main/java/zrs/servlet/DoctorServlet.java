package zrs.servlet;

import zrs.pojo.Doctor;
import zrs.service.DoctorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 医生servlet
 */
@WebServlet("/doctor")
public class DoctorServlet extends HttpServlet {
    DoctorService doctorService = new DoctorService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String method = req.getParameter("method");

        if(method.equals("queryAll") && method != null){
            // 查看所有医生列表
            this.doctorAll(req,resp);
        } else if(method.equals("query") && method != null){
            // 查看单个医生信息
            this.getById(req,resp);
        } else if(method.equals("addDoctor") && method != null){
            // 添加单个医生信息
            this.addDoctor(req,resp);
        } else if(method.equals("delete") && method != null){
            // 删除单个医生信息
            this.deleteDoctor(req,resp);
        } else if(method.equals("update") && method != null){
            // 获取医生的信息传至前端等待用户修改
            int id = Integer.parseInt(req.getParameter("id"));
            Doctor doctor = doctorService.getById(id);
            req.setAttribute("doctor",doctor);
            req.getRequestDispatcher("/page/doctor/modifyDoctor.jsp").forward(req,resp);
        } else if(method.equals("updateDoctor") && method != null){
            // 修改医生的信息
            this.updateDoctor(req,resp);
        } else if(method.equals("select") && method != null){
            // 模糊查询医生信息
            this.selectDoctor(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    /**
     * 查询所有医生的列表
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void doctorAll(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("DoctorServlet--->doctorAll()方法");

        List<Doctor> doctorList = doctorService.queryAll();
        req.setAttribute("doctorList",doctorList);
        req.getRequestDispatcher("/page/doctor/doctorList.jsp").forward(req,resp);
    }

    /**
     * 根据id查询医生
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void getById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("DoctorServlet--->getById()方法");

        // 将地址栏参数列表中的id转换为int类型
        int id = Integer.parseInt(req.getParameter("id"));
        Doctor doctor = doctorService.getById(id);
        if(doctor != null){
            req.setAttribute("doctor",doctor);
            req.getRequestDispatcher("/page/doctor/queryDoctor.jsp").forward(req,resp);
        }
    }

    /**
     * 添加医生信息
     * @param req
     * @param resp
     */
    private void addDoctor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("DoctorServlet--->addDoctor()方法");

        Doctor doctor = new Doctor();
        // 接收前端数据，封装到doctor中
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        // 将前端输入的String类型的日期转化为时间Date类型的日期
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String birthTime = req.getParameter("birthday");
        Date birthday = null;
        try {
            birthday = df.parse(birthTime.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // 将前端输入的String类型数据转化为int类型
        int seniority = Integer.parseInt(req.getParameter("seniority"));
        String post = req.getParameter("post");

        doctor.setName(name);
        doctor.setAge(age);
        doctor.setBirthday(birthday);
        doctor.setSeniority(seniority);
        doctor.setPost(post);

        int count = doctorService.addDoctor(doctor);
        if(count > 0){
            System.out.println("添加医生信息成功！");
            req.getRequestDispatcher("success.jsp").forward(req,resp);
        } else {
            System.out.println("添加医生信息失败！");
            resp.sendRedirect("/doctor?method=queryAll");
        }
    }

    /**
     * 删除单个医生信息
     * @param req
     * @param resp
     */
    private void deleteDoctor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("DoctorServlet--->deleteDoctor()方法");

        int id = Integer.parseInt(req.getParameter("id"));

        int count = doctorService.delete(id);
        if(count > 0){
            System.out.println("删除医生信息成功！");
            req.getRequestDispatcher("success.jsp").forward(req,resp);
        } else {
            System.out.println("删除医生信息失败！");
            resp.sendRedirect("/doctor?method=queryAll");
        }
    }

    /**
     * 修改单个医生信息
     * @param req
     * @param resp
     */
    private void updateDoctor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("DoctorServlet--->updateDoctor()方法");

        Doctor doctor = new Doctor();
        // 接收前端数据，封装到doctor中
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        // 将前端输入的String类型的日期转化为时间Date类型的日期
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String birthTime = req.getParameter("birthday");
        Date birthday = null;
        try {
            birthday = df.parse(birthTime.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // 将前端输入的String类型数据转化为int类型
        int seniority = Integer.parseInt(req.getParameter("seniority"));
        String post = req.getParameter("post");

        doctor.setId(id);
        doctor.setName(name);
        doctor.setAge(age);
        doctor.setBirthday(birthday);
        doctor.setSeniority(seniority);
        doctor.setPost(post);

        int update = doctorService.update(doctor);
        if(update > 0){
            System.out.println("修改医生信息成功！");
            req.getRequestDispatcher("success.jsp").forward(req,resp);
        } else {
            System.out.println("修改医生信息失败！");
            resp.sendRedirect("/doctor?method=queryAll");
        }
    }

    /**
     * 模糊查询医生姓名
     * @param req
     * @param resp
     */
    private void selectDoctor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("DoctorServlet--->selectDoctor()方法");

        // 获取前端页面中通过JavaScript获取到的值
        String name = req.getParameter("value");
        List<Doctor> doctorList = doctorService.selectDoctor(name);
        if(doctorList != null){
            System.out.println("模糊查询医生 %" + name + "% 的信息成功！");
            req.setAttribute("doctorList",doctorList);
            req.getRequestDispatcher("/page/doctor/doctorList.jsp").forward(req,resp);
        } else {
            {
                System.out.println("模糊查询医生信息失败！");
                req.getRequestDispatcher("/page/doctor/doctorList.jsp").forward(req,resp);
            }
        }
    }
}