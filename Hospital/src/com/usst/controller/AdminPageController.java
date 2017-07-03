package com.usst.controller;

import com.usst.model.Doctor;
import com.usst.service.AdminPageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 28444 on 2017/6/29.
 */

@Controller
@RequestMapping("/admin")
public class AdminPageController {

    @Resource
    private AdminPageService adminPageService;

    @RequestMapping("/admin")
    public String admin() {
        return "admin/admin";
    }

    @RequestMapping("/doctor/all_doctor")
    public ModelAndView doctor(){
        ModelAndView mav = new ModelAndView();
        List<Doctor> doctors = adminPageService.getAllDoctor();
        mav.addObject("doctors", doctors);
        mav.setViewName("admin/doctor/all_doctor");
        return mav;
    }

    @RequestMapping("/doctor/add_doctor")
    public ModelAndView addDoctor() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("admin/doctor/add_doctor");
        return mav;
    }




}
