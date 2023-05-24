package zrs.servlet;

import zrs.pojo.User;
import zrs.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 用户servlet
 */
@WebServlet("/login")
public class UserServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("UserServlet--->用户登录方法");
        // 获取前端输入数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // 校验用户名和密码
        User user = userService.query(username, password);
        if (user != null) {
            HttpSession session = req.getSession();
            // 保存用户信息到session中
            session.setAttribute("user", user);
            // 转发到home.jsp页面
            req.getRequestDispatcher("home.jsp").forward(req, resp);
        } else {
            System.out.println("账号或密码不正确！");
            // 重定向到login.html页面
            resp.sendRedirect("login.html");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}