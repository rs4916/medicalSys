package zrs.servlet;

import zrs.pojo.Medicine;
import zrs.service.MedicineService;

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
@WebServlet("/medicine")
public class MedicineServlet extends HttpServlet {
    MedicineService medicineService = new MedicineService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String method = req.getParameter("method");

        if(method.equals("queryAll") && method != null){
            // 查询所有药品信息
            this.medicineAll(req,resp);
        } else if (method.equals("query") && method != null){
            this.query(req,resp);
        } else if (method.equals("add") && method != null){
            this.addMedicine(req,resp);
        } else if (method.equals("delete")&&method!=null){
            this.delete(req,resp);
        } else if (method.equals("update")&&method!=null){
            // 获取药品的信息传至前端等待用户修改
            int id = Integer.parseInt(req.getParameter("id"));
            Medicine medicine = medicineService.query(id);
            req.setAttribute("medicine",medicine);
            req.getRequestDispatcher("/page/medicine/modifyMedicine.jsp").forward(req,resp);
        } else if (method.equals("updateMedicine")&&method!=null){
            this.updateMedicine(req,resp);
        } else if (method.equals("select")&&method!=null){
            this.selectMedicine(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    /**
     * 查询所有药品信息
     * @param req
     * @param resp
     */
    private void medicineAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("MedicineServlet--->medicineAll()方法");

        List<Medicine> medicineList = medicineService.queryAll();
        req.setAttribute("medicineList",medicineList);
        req.getRequestDispatcher("/page/medicine/medicineList.jsp").forward(req,resp);
    }

    /**
     * 根据id查看药品信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("MedicineServlet--->query()方法");

        int id = Integer.parseInt(req.getParameter("id"));
        Medicine medicine = medicineService.query(id);
        if(medicine != null){
            req.setAttribute("medicine",medicine);
            req.getRequestDispatcher("/page/medicine/queryMedicine.jsp").forward(req,resp);
        }
    }

    private void addMedicine(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("MedicineServlet--->addMedicine()方法");

        Medicine medicine=new Medicine();
        String name=req.getParameter("name");
        String function=req.getParameter("function");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String date_of_manufactureTime = req.getParameter("date_of_manufacture");
        Date date_of_manufacture = null;
        try {
            date_of_manufacture = df.parse(date_of_manufactureTime.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String address=req.getParameter("address");
        String taboo=req.getParameter("taboo");
        Double price= Double.parseDouble(req.getParameter("price"));

        medicine.setName(name);
        medicine.setFunction(function);
        medicine.setDate_of_manufacture(date_of_manufacture);
        medicine.setAddress(address);
        medicine.setTaboo(taboo);
        medicine.setPrice(price);

        int i = medicineService.addMedicine(medicine);
        if (i > 0){
            System.out.println("添加药品成功！");
            req.getRequestDispatcher("success.jsp").forward(req,resp);
        } else {
            System.out.println("添加药品失败！");
            resp.sendRedirect("/medicine?method=queryAll");
        }
    }

    /**
     * 根据id删除药品
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("MedicineServlet--->delete()方法");

        int id = Integer.parseInt(req.getParameter("id"));

        int delete = medicineService.delete(id);
        if (delete > 0){
            System.out.println("删除药品成功！");
            req.getRequestDispatcher("success.jsp").forward(req,resp);
        }else {
            System.out.println("删除药品失败！");
            resp.sendRedirect("/medicine?method=queryAll");
        }
    }

    /**
     * 根据id修改药品信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void updateMedicine(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("MedicineServlet--->updateMedicine()方法");

        Medicine medicine = new Medicine();
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String function = req.getParameter("function");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String date_of_manufactureTime = req.getParameter("date_of_manufacture");
        Date date_of_manufacture = null;
        try {
            date_of_manufacture = df.parse(date_of_manufactureTime.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String address = req.getParameter("address");
        String taboo = req.getParameter("taboo");
        Double price = Double.parseDouble(req.getParameter("price"));

        medicine.setId(id);
        medicine.setName(name);
        medicine.setFunction(function);
        medicine.setDate_of_manufacture(date_of_manufacture);
        medicine.setAddress(address);
        medicine.setTaboo(taboo);
        medicine.setPrice(price);

        int update = medicineService.update(medicine);
        if (update > 0){
            System.out.println("药品修改成功！");
            req.getRequestDispatcher("success.jsp").forward(req,resp);
        }else {
            System.out.println("药品修改失败！");
            resp.sendRedirect("/medicine?method=queryAll");
        }
    }

    /**
     * 模糊查询药品名字
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void selectMedicine(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("MedicineServlet--->selectMedicine()方法");

        String name=req.getParameter("value");

        List<Medicine> medicineList = medicineService.select(name);
        req.setAttribute("medicineList",medicineList);
        req.getRequestDispatcher("/page/medicine/medicineList.jsp").forward(req,resp);
    }
}