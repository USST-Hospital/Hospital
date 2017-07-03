package com.usst.controller;

import com.usst.service.NursePageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by 28444 on 2017/6/29.
 */


@Controller
@RequestMapping("/nurse")
public class NursePageController {

    @Resource
    private NursePageService nursePageService;


    @RequestMapping("information")
    public ModelAndView information() {
        ModelAndView mav = new ModelAndView();


        return mav;
    }


    @RequestMapping("schedule")
    public ModelAndView schedule() {
        ModelAndView mav = new ModelAndView();


        return mav;
    }


}
