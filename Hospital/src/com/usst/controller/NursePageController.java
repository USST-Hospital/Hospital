package com.usst.controller;

import com.usst.model.Operation;
import com.usst.service.NursePageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by 28444 on 2017/6/29.
 */


@Controller
@RequestMapping("/nurse")
public class NursePageController {

    @Resource
    private NursePageService nursePageService;



    @RequestMapping("/nurse")
    public String nurse() {
        return "/nurse/nurse";
    }


    @RequestMapping("/information")
    public ModelAndView information(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("nurse/information");
        int account = Integer.parseInt(request.getSession().getAttribute("account").toString());
        mav.addObject("nurse",nursePageService.getNurseById(account));
        return mav;
    }


    @RequestMapping("/schedule")
    public ModelAndView schedule(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("analgesist/schedule");
        int account = Integer.parseInt(request.getSession().getAttribute("account").toString());
        List<Operation> operations = nursePageService.getSchedule(account);
        mav.addObject("operations", operations);
        return mav;
    }

    @RequestMapping("/history")
    public ModelAndView history(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("analgesist/history");
        int account = Integer.parseInt(request.getSession().getAttribute("account").toString());
        List<Operation> operations = nursePageService.getHistory(account);
        mav.addObject("operations", operations);
        return mav;
    }


}
