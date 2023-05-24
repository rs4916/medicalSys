package zrs.servlet;

import zrs.pojo.Register;
import zrs.pojo.User;
import zrs.service.RegisterService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author rsZheng
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    RegisterService registerService = new RegisterService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String method = req.getParameter("method");
        if (method.equals("add") && method != null) {
            // 挂号功能
            this.addRegister(req, resp);
        } else if (method.equals("queryAll") && method != null) {
            // 查询所有病历
            this.queryAll(req, resp);
        } else if (method.equals("getNoPayList") && method != null) {
            // 根据id查询病人的未付款列表
            this.getNoPayList(req, resp);
        } else if (method.equals("payAllCost") && method != null) {
            // 点击“缴费”按钮缴费
            this.payAllCost(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    /**
     * 挂号功能
     * @param req
     * @param resp
     * @throws IOException
     * @throws ServletException
     */
    private void addRegister(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        System.out.println("RegisterServlet--->addRegister()方法");

        Register register = new Register();
        int did = Integer.parseInt(req.getParameter("did"));
        int pid = Integer.parseInt(req.getParameter("pid"));
        int mid = Integer.parseInt(req.getParameter("mid"));
        // 此处无需获取uid，用户登录时已将id存入session，可通过session获取
        // 是否付款也无需设置，数据库已经添加默认值'未付款'
        register.setDid(did);
        register.setMid(mid);
        register.setPid(pid);

        // 获取session中的user.id
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        // 将id设置回到register实体类中
        register.setUid(user.getId());

        // 获取当前时间
        Date date = new Date();
        // SimpleDateFormat自定义日期时间格式
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd ");
        // 将获取的当前时间转为自定义的日期时间格式
        String format = dateFormat.format(date);

        DateFormat dd = new SimpleDateFormat("yyyy-MM-dd");
        Date creation_time = null;
        try {
            creation_time = dd.parse(format.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        register.setCreation_time(creation_time);

        int i = registerService.addRegister(register);
        if (i > 0) {
            System.out.println("挂号功能成功！");
            req.getRequestDispatcher("success.jsp").forward(req, resp);
        } else {
            System.out.println("挂号功能失败！");
            resp.sendRedirect("/register?method=queryAll");
        }
    }

    /**
     * 查询所有病历
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void queryAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("RegisterServlet--->queryAll()方法");

        List<Register> registerList = registerService.queryAll();
        req.setAttribute("registerList", registerList);
        req.getRequestDispatcher("/page/register/registerList.jsp").forward(req, resp);
    }

    /**
     * 根据病人id查询其未付款列表
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void getNoPayList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("RegisterServlet--->getNoPayList()方法");

        // 获取前端输入的病人pid，点击缴费按钮时需要作参数传递
        int pid = Integer.parseInt(req.getParameter("pid"));
        req.setAttribute("pid", pid);

        List<Register> registerList = registerService.findNoPayListByPId(pid);
        if(registerList.size() > 0){
            System.out.println("查询病人未付款列表成功！");
            req.setAttribute("registerList", registerList);
            req.getRequestDispatcher("/page/pay/payList.jsp").forward(req, resp);
        } else {
            req.setCharacterEncoding("utf-8");
//            req.setAttribute("noPayList","当前病人暂无未付款列表！");
            System.out.println("当前病人暂无未付款列表！");
            req.getRequestDispatcher("/pay/pay.jsp").forward(req,resp);
        }
    }

    /**
     * 缴清未付款列表的订单
     * @param req
     * @param resp
     * @throws IOException
     * @throws ServletException
     */
    private void payAllCost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        System.out.println("RegisterServlet--->payAllCost()方法");

        // 获取前端输入的病人id
        int pid = Integer.parseInt(req.getParameter("pid"));
        int payCost = registerService.payAllCost(pid);

        if (payCost > 0) {
            System.out.println("缴费成功");
            req.getRequestDispatcher("success.jsp").forward(req, resp);
        } else {
            System.out.println("缴费失败");
            resp.sendRedirect("/register?method=getNoPayList");
        }
    }
}