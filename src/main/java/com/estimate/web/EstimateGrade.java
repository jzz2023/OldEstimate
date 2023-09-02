package com.estimate.web;

import com.alibaba.fastjson.JSON;
import com.estimate.pojo.Egrade;
import com.estimate.pojo.PageBean;
import com.estimate.service.EgradeService;
import com.estimate.service.impl.EgradeServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/grade/*")
public class EstimateGrade extends BaseServlet{
    private EgradeService service = new EgradeServiceImpl();

    public void getDaily(HttpServletRequest request, HttpServletResponse response) throws IOException{
        List<Egrade> list = service.getDailylife();
        String s = JSON.toJSONString(list);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(s);
    }

    public void getPsychosis(HttpServletRequest request, HttpServletResponse response) throws IOException{
        List<Egrade> list = service.getPsychosis();
        String s = JSON.toJSONString(list);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(s);
    }

    public void getSense(HttpServletRequest request, HttpServletResponse response) throws IOException{
        List<Egrade> list = service.getSense();
        String s = JSON.toJSONString(list);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(s);
    }

    public void getInvolve(HttpServletRequest request, HttpServletResponse response) throws IOException{
        List<Egrade> list = service.getInvolve();
        String s = JSON.toJSONString(list);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(s);
    }

    public void getColumnar(HttpServletRequest request, HttpServletResponse response) throws IOException{
        List<Egrade> list = service.getColumnar();
        String s = JSON.toJSONString(list);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(s);
    }

    public void selectPageAndCondition(HttpServletRequest request, HttpServletResponse response) throws IOException{
        request.setCharacterEncoding("utf-8");
        int currentPage = Integer.parseInt(request.getParameter("page"));
        int size = Integer.parseInt(request.getParameter("limit"));
        String oldername = request.getParameter("oldername");
        String regno = request.getParameter("regno");
        String enumber = request.getParameter("enumber");
        Egrade egrade = new Egrade();
        egrade.setOldername(oldername);
        egrade.setRegno(regno);
        egrade.setEnumber(enumber);
        PageBean<Egrade> pageBean = service.selectPageAndCondition(currentPage, size, egrade);
        String s = JSON.toJSONString(pageBean);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(s);
    }

    public void selectPage(HttpServletRequest request, HttpServletResponse response) throws IOException{
        request.setCharacterEncoding("utf-8");
        int currentPage = Integer.parseInt(request.getParameter("page"));
        int size = Integer.parseInt(request.getParameter("limit"));
        PageBean<Egrade> pageBean = service.selectByPage(currentPage,size);
        String s = JSON.toJSONString(pageBean);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(s);
    }

    public void updateDaily(HttpServletRequest request, HttpServletResponse response) throws IOException{
        request.setCharacterEncoding("utf-8");
        String grade = request.getParameter("grade");
        String regno = request.getParameter("regno");
        Egrade e = new Egrade();
        e.setDailylife(grade);
        e.setRegno(regno);
        service.updateDaily(e);
        response.getWriter().write("success");
    }

    public void updatePsychosis(HttpServletRequest request, HttpServletResponse response) throws IOException{
        request.setCharacterEncoding("utf-8");
        String grade = request.getParameter("grade");
        String regno = request.getParameter("regno");
        Egrade e = new Egrade();
        e.setPsychosis(grade);
        e.setRegno(regno);
        service.updatePsychosis(e);
        response.getWriter().write("success");
    }

    public void updateSense(HttpServletRequest request, HttpServletResponse response) throws IOException{
        request.setCharacterEncoding("utf-8");
        String grade = request.getParameter("grade");
        String regno = request.getParameter("regno");
        Egrade e = new Egrade();
        e.setSense(grade);
        e.setRegno(regno);
        service.updateSense(e);
        response.getWriter().write("success");
    }

    public void updateInvolve(HttpServletRequest request, HttpServletResponse response) throws IOException{
        request.setCharacterEncoding("utf-8");
        String grade = request.getParameter("grade");
        String regno = request.getParameter("regno");
        Egrade egrade = service.getByRegno(regno);
        Egrade e = new Egrade();
        e.setInvolve(grade);
        e.setRegno(regno);
        int number = Integer.parseInt(egrade.getEnumber());
        number ++;
        e.setEnumber(String.valueOf(number));
        service.updateInvolve(e);
        response.getWriter().write("success");
    }

    public void selectPageByDaily(HttpServletRequest request, HttpServletResponse response) throws IOException{
        request.setCharacterEncoding("utf-8");
        int currentPage = Integer.parseInt(request.getParameter("page"));
        int size = Integer.parseInt(request.getParameter("limit"));
        String dailylife = request.getParameter("dailylife");
        PageBean<Egrade> pageBean = service.selectPageByDaily(currentPage, size, dailylife);
        String s = JSON.toJSONString(pageBean);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(s);
    }

    public void selectPageByPsychosis(HttpServletRequest request, HttpServletResponse response) throws IOException{
        request.setCharacterEncoding("utf-8");
        int currentPage = Integer.parseInt(request.getParameter("page"));
        int size = Integer.parseInt(request.getParameter("limit"));
        String psychosis = request.getParameter("psychosis");
        PageBean<Egrade> pageBean = service.selectPageByPsychosis(currentPage, size, psychosis);
        String s = JSON.toJSONString(pageBean);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(s);
    }

    public void selectPageBySense(HttpServletRequest request, HttpServletResponse response) throws IOException{
        request.setCharacterEncoding("utf-8");
        int currentPage = Integer.parseInt(request.getParameter("page"));
        int size = Integer.parseInt(request.getParameter("limit"));
        String sense = request.getParameter("sense");
        PageBean<Egrade> pageBean = service.selectPageBySense(currentPage, size, sense);
        String s = JSON.toJSONString(pageBean);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(s);
    }

    public void selectPageByInvolve(HttpServletRequest request, HttpServletResponse response) throws IOException{
        request.setCharacterEncoding("utf-8");
        int currentPage = Integer.parseInt(request.getParameter("page"));
        int size = Integer.parseInt(request.getParameter("limit"));
        String involve = request.getParameter("involve");
        PageBean<Egrade> pageBean = service.selectPageByInvolve(currentPage, size, involve);
        String s = JSON.toJSONString(pageBean);
        System.out.println(s);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(s);
    }

}
