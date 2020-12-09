package com.cykj.servlet;

import com.cykj.bean.Admin;
import com.cykj.bean.Discuser;
import com.cykj.dao.LoginDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String modName = req.getParameter("modName");
        LoginDao loginDao = new LoginDao();
        if (modName.equals("adminLogin")){
            String account = req.getParameter("account");
            String pwd = req.getParameter("pwd");
            Admin admin = new Admin();
            admin.setAccount(account);
            admin.setPwd(pwd);
            List<Admin> admins= loginDao.adminLogin(admin);
            if (admins.size()==1){
                req.getSession().setAttribute("admin",admins.get(0));
                resp.getWriter().write("登录成功");
            }else {
                resp.getWriter().write("登录失败");
            }
        }
        if (modName.equals("login")){
            String account = req.getParameter("account");
            String pwd = req.getParameter("pwd");
            Discuser discuser = new Discuser();
            discuser.setDaccount(account);
            discuser.setDpwd(pwd);
            List<Discuser> discusers = loginDao.login(discuser);
            if (discusers.size()==1){
                req.getSession().setAttribute("discuser",discusers.get(0));
                resp.getWriter().write("登录成功");
            }else {
                resp.getWriter().write("登录失败");
            }
        }
        if (modName.equals("existence")){
            String daccount = req.getParameter("account");
            Discuser discuser = new Discuser();
            discuser.setDaccount(daccount);
            int cou = loginDao.existence(discuser);
            if (cou>0){
                resp.getWriter().write("有");
            }else {
                resp.getWriter().write("无");
            }
        }
        if (modName.equals("register")){
            Discuser discuser = new Discuser();
            String account=req.getParameter("account");
            String pwd=req.getParameter("pwd");
            String sex = req.getParameter("sex");
            String education=req.getParameter("education");
            String major =req.getParameter("major");
            String phone = req.getParameter("phone");
            String email = req.getParameter("email");
            if (sex.equals("1")){
                sex="男";
            }else {
                sex="女";
            }
            discuser.setDaccount(account);
            discuser.setDpwd(pwd);
            discuser.setSex(sex);
            discuser.setEducation(education);
            discuser.setMajor(major);
            discuser.setPhone(phone);
            discuser.setEmail(email);
            int r = loginDao.regiser(discuser);
            if (r>0){
                resp.getWriter().write("注册成功");
            }else {
                resp.getWriter().write("注册失败");
            }
        }
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
