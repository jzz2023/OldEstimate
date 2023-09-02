package com.estimate.web;

import com.alibaba.fastjson.JSON;
import com.estimate.pojo.Egrade;
import com.estimate.pojo.OlderTree;
import com.estimate.pojo.PageBean;
import com.estimate.service.TreeService;
import com.estimate.service.impl.TreeServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/tree/*")
public class Tree extends BaseServlet{
    private TreeService service = new TreeServiceImpl();

    public void getTree(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<OlderTree> trees = service.getAll();
        response.setContentType("text/json;charset=utf-8");
        String s = JSON.toJSONString(trees);
        response.getWriter().write(s);
    }

    public void getTreePageAndCondition(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        int currentPage = Integer.parseInt(request.getParameter("page"));
        int pageSize = Integer.parseInt(request.getParameter("limit"));
        String dailylife = request.getParameter("dailylife");
        String psychosis = request.getParameter("psychosis");
        String sense = request.getParameter("sense");
        String involve = request.getParameter("involve");
        Egrade egrade = new Egrade();
        egrade.setDailylife(dailylife);
        egrade.setPsychosis(psychosis);
        egrade.setSense(sense);
        egrade.setInvolve(involve);
        PageBean<Egrade> pageBean = service.selectTreePageAndCondition(currentPage, pageSize, egrade);
        String s = JSON.toJSONString(pageBean);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(s);
    }
}
