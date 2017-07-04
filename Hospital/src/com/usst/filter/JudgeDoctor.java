package com.usst.filter;

import com.usst.dao.DoctorMapper;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 28444 on 2017/7/2.
 */
@WebFilter(filterName = "JudgeDoctor",urlPatterns ="/doctor/*")
public class JudgeDoctor implements Filter {

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletResponse response =(HttpServletResponse)resp;
        HttpServletRequest request= (HttpServletRequest) req;
        try {
            String power = request.getSession().getAttribute("power").toString();
            if (!"doctor".equals(power)) {
                response.sendRedirect("/Hospital/index.jsp");
                return;
            }
        } catch (Exception e) {
            //e.printStackTrace();
            response.sendRedirect("/Hospital/index.jsp");
            return;
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
