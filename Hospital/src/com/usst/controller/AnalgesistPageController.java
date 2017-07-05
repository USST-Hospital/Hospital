package com.usst.controller;

import com.usst.model.Operation;
import com.usst.service.AnalgesistPageService;
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
@RequestMapping("/analgesist")
public class AnalgesistPageController {
    @Resource
    private AnalgesistPageService analgesistPageService;

    @RequestMapping("/analgesist")
    public String analgesist() {
        return "/analgesist/analgesist";
    }

    @RequestMapping("/information")
    public ModelAndView information(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("analgesist/information");
        System.out.println("controller info");
        int account = Integer.parseInt(request.getSession().getAttribute("account").toString());
        mav.addObject("analgesist",analgesistPageService.getAnalgesistById(account));
        return mav;
    }

    @RequestMapping("/schedule")
    public ModelAndView schedule(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("analgesist/schedule");
        int account = Integer.parseInt(request.getSession().getAttribute("account").toString());
        List<Operation> operations = analgesistPageService.getSchedule(account);
        System.out.println(operations.size());
        mav.addObject("operations", operations);
        return mav;
    }

    @RequestMapping("/history")
    public ModelAndView history(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("analgesist/history");
        int account = Integer.parseInt(request.getSession().getAttribute("account").toString());
        List<Operation> operations = analgesistPageService.getHistory(account);
        System.out.println(operations.size());
        mav.addObject("operations", operations);
        return mav;
    }


}
