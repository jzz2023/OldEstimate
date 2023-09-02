package com.estimate.web;

import com.estimate.pojo.User;
import com.estimate.service.UserService;
import com.estimate.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/loginServlet")
public class LoginServlet extends HttpServlet {
    private UserService service = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");
        String identity = request.getParameter("identity");
        User user = new User();
        user.setUsername(username);
        user.setPwd(pwd);
        user.setIdentity(identity);
        boolean b = service.login(user);
        response.setContentType("text/html;charset=utf-8");
        if(b){
            response.sendRedirect("estimate.html");
        }else {
            response.getWriter().println("<script>alert('用户名或密码错误');window.location.href='index.html'</script>");
        }
    }
}
