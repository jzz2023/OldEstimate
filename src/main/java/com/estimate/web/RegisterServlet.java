package com.estimate.web;

import com.estimate.pojo.User;
import com.estimate.service.UserService;
import com.estimate.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    private UserService service = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = null;
        String phone = request.getParameter("phone");
        String pwd = request.getParameter("pwd");
        String identity = request.getParameter("identity");
        if(identity.equals("2")){
            username = "comm" + getUsername(phone);
        }else if(identity.equals("1")){
            username = "mate" + getUsername(phone);
        }
        User user = new User();
        user.setUsername(username);
        user.setPwd(pwd);
        user.setPhone(phone);
        user.setIdentity(identity);
        service.register(user);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println("<script>alert('注册成功，你的账号为：'+'"+username+"');" +
                "window.location.href='index.html'</script>");
    }

    public String getUsername(String str){
        char[] basicArray = str.toCharArray();
        Random random = new Random();
        char[] result = new char[6];
        for (int i = 0; i < result.length; i++) {
            int index = random.nextInt(100) % (basicArray.length);
            result[i] = basicArray[index];
        }
        return new String(result);
    }
}
