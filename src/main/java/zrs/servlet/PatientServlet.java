package zrs.servlet;

import zrs.pojo.Doctor;
import zrs.pojo.Patient;
import zrs.service.PatientService;

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
 * @author rsZheng
 */
@WebServlet("/patient")
public class PatientServlet extends HttpServlet {
    PatientService patientService = new PatientService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String method = req.getParameter("method");
        if(method.equals("queryAll") && method != null){
            // 查询所有病人信息
            this.patientAll(req,resp);
        } else if (method.equals("query") && method != null){
            // 根据id查看病人信息
            this.query(req,resp);
        } else if (method.equals("update") && method != null){
            // 获取病人的信息传至前端等待用户修改
            int id = Integer.parseInt(req.getParameter("id"));
            Patient patient = patientService.query(id);
            req.setAttribute("patient",patient);
            req.getRequestDispatcher("/page/patient/modifyPatient.jsp").forward(req,resp);
        } else if (method.equals("updatepatient")&&method!=null){
            // 修改病人信息
            this.updatePatient(req,resp);
        } else if (method.equals("delete") && method != null){
            // 根据id删除病人
            this.deletePatient(req,resp);
        } else if (method.equals("addPatient") && method != null){
            this.addPatient(req,resp);
        } else if (method.equals("select") && method != null){
            this.selectPatient(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    /**
     * 查询所有病人信息
     * @param req
     * @param resp
     */
    private void patientAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("PatientServlet--->patientAll()方法");

        List<Patient> patientList = patientService.queryAll();
        req.setAttribute("patientList",patientList);
        req.getRequestDispatcher("/page/patient/patientList.jsp").forward(req,resp);
    }

    /**
     * 根据id查看病人信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("PatientServlet--->query()方法");

        int id = Integer.parseInt(req.getParameter("id"));
        Patient patient = patientService.query(id);
        req.setAttribute("patient",patient);
        req.getRequestDispatcher("/page/patient/queryPatient.jsp").forward(req,resp);
    }

    /**
     * 修改单个病人信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void updatePatient(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("PatientServlet--->updatePatient()方法");

        Patient patient = new Patient();
        // 接收前端数据，封装到patient中
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
        Double balance = Double.parseDouble(req.getParameter("balance"));
        String address = req.getParameter("address");

        patient.setId(id);
        patient.setAge(age);
        patient.setName(name);
        patient.setBirthday(birthday);
        patient.setBalance(balance);
        patient.setAddress(address);

        int update = patientService.update(patient);
        if (update > 0) {
            System.out.println("修改病人信息成功！");
            req.getRequestDispatcher("success.jsp").forward(req,resp);
        } else {
            System.out.println("修改病人信息失败！");
            resp.sendRedirect("/patient?method=queryAll");
        }
    }

    /**
     * 根据id删除病人
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void deletePatient(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("PatientServlet--->deletePatient()方法");

        int id = Integer.parseInt(req.getParameter("id"));
        int delete = patientService.delete(id);

        if (delete > 0){
            System.out.println("删除病人信息成功！");
            req.getRequestDispatcher("success.jsp").forward(req,resp);
        }else{
            System.out.println("删除病人信息失败!");
            resp.sendRedirect("/patient?method=queryAll");
        }
    }

    /**
     * 添加病人信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void addPatient(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("PatientServlet--->addPatient()方法");

        Patient patient = new Patient();
        // 接收前端数据，封装到patient中
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
        Double balance = Double.parseDouble(req.getParameter("balance"));
        String address = req.getParameter("address");

        patient.setAge(age);
        patient.setName(name);
        patient.setBirthday(birthday);
        patient.setBalance(balance);
        patient.setAddress(address);

        int update = patientService.addPatient(patient);
        if(update > 0){
            System.out.println("添加病人信息成功！");
            req.getRequestDispatcher("success.jsp").forward(req,resp);
        } else {
            System.out.println("添加病人信息失败！");
            resp.sendRedirect("/patient?method=queryAll");
        }
    }

    /**
     * 模糊查询病人姓名
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void selectPatient(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("PatientServlet--->selectPatient()方法");

        // 获取前端页面中通过JavaScript获取到的值
        String name = req.getParameter("value");
        List<Patient> patientList = patientService.select(name);

        if(patientList != null){
            System.out.println("模糊查询病人 %" + name + "% 的信息成功！");
            req.setAttribute("patientList",patientList);
            req.getRequestDispatcher("/page/patient/patientList.jsp").forward(req,resp);
        } else {
            {
                System.out.println("模糊查询医生信息失败！");
                req.getRequestDispatcher("/page/patient/patientList.jsp").forward(req,resp);
            }
        }
    }
}
