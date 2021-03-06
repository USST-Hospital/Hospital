package com.usst.controller;

import com.sun.deploy.net.HttpResponse;
import com.usst.service.LoginPageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.spec.ECField;

/**
 * Created by 28444 on 2017/6/29.
 */
@Controller

public class LoginController {

    @Resource
    private LoginPageService loginPageService;

    @RequestMapping("login")
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        try {
            String power = request.getParameter("power");
            int account = Integer.parseInt(request.getParameter("account"));
            String password = request.getParameter("password");
            if (loginPageService.login(power, account, password)) {
                request.getSession().setAttribute("power", power);
                request.getSession().setAttribute("account", account);
                String personText = loginPageService.getPersonText(account,power);
                request.getSession().setAttribute("personText",personText);
                out.print("success");
            } else {
                out.print("failure");
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.print("failure");
        } finally {
            out.close();
        }
    }

    @RequestMapping("show_login")
    public String show_login(HttpServletRequest request) {
        return "show_login";
    }

    @RequestMapping("logout")
    public String logout(HttpServletRequest request) {
        try {
            request.getSession().removeAttribute("account");
            request.getSession().removeAttribute("power");
            request.getSession().removeAttribute("personText");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return "show_login";
        }
    }

    @RequestMapping("/getOperationInfo")
    public void getOperationInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter out = response.getWriter();
        try {
            String power = request.getSession().getAttribute("power").toString();
            int account = Integer.parseInt(request.getSession().getAttribute("account").toString());
            if (loginPageService.getOperationInfo(account, power)) {
                out.print("havaOperationInfo");
            }else {
                out.print("noOperationInfo");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            out.close();
        }
    }

    @RequestMapping("/changeOperationInfo")
    public void changeOperationInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter out = response.getWriter();
        try {
            String power = request.getSession().getAttribute("power").toString();
            int account = Integer.parseInt(request.getSession().getAttribute("account").toString());
            loginPageService.changeOperationInfo(account,power);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            out.close();
        }
    }
}
