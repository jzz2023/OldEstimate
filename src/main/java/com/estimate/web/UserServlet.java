package com.estimate.web;

import com.alibaba.fastjson.JSON;
import com.estimate.pojo.Egrade;
import com.estimate.pojo.PageBean;
import com.estimate.pojo.User;
import com.estimate.service.UserService;
import com.estimate.service.impl.UserServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet{

    private UserService service = new UserServiceImpl();

    public void selectPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        int currentPage = Integer.parseInt(request.getParameter("page"));
        int size = Integer.parseInt(request.getParameter("limit"));
        PageBean<User> pageBean = service.findByPage(currentPage,size);
        String s = JSON.toJSONString(pageBean);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(s);
    }

    public void selectCondition(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        int currentPage = Integer.parseInt(request.getParameter("page"));
        int size = Integer.parseInt(request.getParameter("limit"));
        User user=new User();
        String condition = request.getParameter("condition");
        String user_input=request.getParameter("user_input");
        if(condition.equals("100")){
            user.setId(Integer.parseInt(user_input));
        }else if(condition.equals("101")){
            user.setUsername(user_input);
        }
        PageBean<User> pageBean = service.findByPageandCondition(currentPage,size,user);
        String s = JSON.toJSONString(pageBean);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(s);
    }

    public void resetPwd(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        service.resetPwd(id);
        response.getWriter().write("success");
    }

    public void delUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        service.delUser(id);
        response.getWriter().write("success");
    }
}
