package com.estimate.web;

import com.alibaba.fastjson.JSON;
import com.estimate.pojo.Egrade;
import com.estimate.pojo.Older;
import com.estimate.pojo.PageBean;
import com.estimate.service.EgradeService;
import com.estimate.service.OlderService;
import com.estimate.service.impl.EgradeServiceImpl;
import com.estimate.service.impl.OlderServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/estimate/*")
public class Estimate extends BaseServlet{
    private OlderService service=new OlderServiceImpl();

    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Older> olders = service.getAll();
        String s = JSON.toJSONString(olders);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(s);
    }

    public void selectByPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int currentPage = Integer.parseInt(request.getParameter("page"));
        int size = Integer.parseInt(request.getParameter("limit"));
        PageBean<Older> pageBean = service.selectByPage(currentPage, size);
        String s = JSON.toJSONString(pageBean);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(s);
    }

    public void selectByPageandCondition(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int currentPage = Integer.parseInt(request.getParameter("page"));
        int size = Integer.parseInt(request.getParameter("limit"));
        String estimate_id = request.getParameter("estimate_id");
        String estimate_name = request.getParameter("estimate_name");
        Older older = new Older();
        older.setEstimate_id(estimate_id);
        older.setEstimate_name(estimate_name);
        PageBean<Older> pageBean = service.selectByPageandCondition(currentPage,size,older);
        String s = JSON.toJSONString(pageBean);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(s);
    }

    public void addOlder(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        String estimate_id = request.getParameter("estimate_id");
        String es_date = request.getParameter("es_date");
        String es_case = request.getParameter("es_case");
        String estimate_name = request.getParameter("estimate_name");
        String sex = request.getParameter("sex");
        String es_birth = request.getParameter("es_birth");
        String IDCard = request.getParameter("IDCard");
        String card = request.getParameter("card");
        String nation = request.getParameter("nation");
        String educate = request.getParameter("educate");
        String orgion = request.getParameter("orgion");
        String marry = request.getParameter("marry");
        String live_status = request.getParameter("live_status");
        String medical = request.getParameter("medical");
        String economy = request.getParameter("economy");
        String sick = request.getParameter("sick");
        String accident = request.getParameter("accident");
        String p_name = request.getParameter("p_name");
        String relation = request.getParameter("relation");
        String r_name = request.getParameter("r_name");
        String r_phone = request.getParameter("r_phone");
        Older older = new Older();
        older.setEstimate_id(estimate_id);
        older.setEs_date(es_date);
        older.setEs_case(es_case);
        older.setEstimate_name(estimate_name);
        older.setSex(sex);
        older.setEs_birth(es_birth);
        older.setIDCard(IDCard);
        older.setCard(card);
        older.setNation(nation);
        older.setEducate(educate);
        older.setOrgion(orgion);
        older.setMarry(marry);
        older.setLive_status(live_status);
        older.setMedical(medical);
        older.setEconomy(economy);
        older.setSick(sick);
        older.setAccident(accident);
        older.setP_name(p_name);
        older.setRelation(relation);
        older.setR_name(r_name);
        older.setR_phone(r_phone);
        service.add_estimate(older);
        EgradeService egradeService = new EgradeServiceImpl();
        Egrade e = new Egrade();
        e.setOldername(estimate_name);
        e.setRegno(estimate_id);
        e.setEnumber("0");
        boolean b = egradeService.addOlder(e);
        if(b){
            response.getWriter().write("success");
        }else {
            response.getWriter().write("error");
        }
    }

    public void deleteOlder(HttpServletRequest request, HttpServletResponse response) throws IOException{
        request.setCharacterEncoding("utf-8");
        String estimate_id = request.getParameter("estimate_id");
        service.deleteOlder(estimate_id);
        response.getWriter().write("success");
    }

    public void updateOlder(HttpServletRequest request, HttpServletResponse response) throws IOException{
        request.setCharacterEncoding("utf-8");
        String estimate_id = request.getParameter("tel_id");
        String es_date = request.getParameter("tel_esdate");
        String es_case = request.getParameter("tel_case");
        String estimate_name = request.getParameter("tel_esname");
        String sex = request.getParameter("tel_sex");
        String es_birth = request.getParameter("tel_birdate");
        String IDCard = request.getParameter("tel_idcard");
        String card = request.getParameter("tel_shebao");
        String nation = request.getParameter("tel_nation");
        String educate = request.getParameter("tel_educate");
        String orgion = request.getParameter("tel_orgion");
        String marry = request.getParameter("tel_marry");
        String live_status = request.getParameter("tel_lstatus");
        String medical = request.getParameter("tel_medical");
        String economy = request.getParameter("tel_economy");
        String sick = request.getParameter("tel_sick");
        String accident = request.getParameter("tel_accident");
        String p_name = request.getParameter("tel_pname");
        String relation = request.getParameter("tel_relation");
        String r_name = request.getParameter("tel_rname");
        String r_phone = request.getParameter("tel_rphone");
        Older older = new Older();
        older.setEstimate_id(estimate_id);
        older.setEs_date(es_date);
        older.setEs_case(es_case);
        older.setEstimate_name(estimate_name);
        older.setSex(sex);
        older.setEs_birth(es_birth);
        older.setIDCard(IDCard);
        older.setCard(card);
        older.setNation(nation);
        older.setEducate(educate);
        older.setOrgion(orgion);
        older.setMarry(marry);
        older.setLive_status(live_status);
        older.setMedical(medical);
        older.setEconomy(economy);
        older.setSick(sick);
        older.setAccident(accident);
        older.setP_name(p_name);
        older.setRelation(relation);
        older.setR_name(r_name);
        older.setR_phone(r_phone);
        service.updateOlder(older);
        response.getWriter().write("success");
    }

    public void uploadExcel(HttpServletRequest request, HttpServletResponse response) throws IOException{

    }
}
