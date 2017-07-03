package com.usst.controller;

import com.usst.model.Doctor;
import com.usst.model.Operation;
import com.usst.service.DoctorPageService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by 28444 on 2017/6/29.
 */
@Controller
@RequestMapping("/doctor")
public class DoctorPageController {

    @Resource
    private DoctorPageService doctorPageService;

    @RequestMapping("/doctor")
    public String doctor() {
        return "doctor/doctor";
    }



    @RequestMapping("/information")
    public ModelAndView information(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("doctor/information");
        System.out.println("controller info");
       // int id = Integer.parseInt(request.getSession().getAttribute("id").toString());
        mav.addObject("doctorInfo",doctorPageService.getDoctorInfoById(1001));
        return mav;
    }

    @RequestMapping("/test")
    public String test() {

     //   doctorService.addDoctor(new Doctor(1,"hello"));
        return "test";
    }

    @RequestMapping("history")
    public ModelAndView history() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("doctor/history");
        List<Operation> operations = doctorPageService.getHistory(1001);
        mav.addObject("operations", operations);
        return mav;
    }

    @RequestMapping("/schedule")
    public ModelAndView schedule() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("doctor/schedule");
        List<Operation> operations = doctorPageService.getSchedule(1001);
        mav.addObject("operations", operations);
        return mav;
    }

    @RequestMapping("appointment")
    public ModelAndView appointment() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("doctor/appointment");
        Doctor doctor=doctorPageService.getDoctorInfoById(1001);
        mav.addObject("appointmentDoctor",doctor.getId()+"  "+doctor.getName());
        mav.addObject("doctorId", doctor.getId());
        return mav;
    }

    @RequestMapping("appointmentGetPatientName")
    public void appointmentGetPatientName(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out=response.getWriter();
        try {
            String patientName = doctorPageService.appointmentGetPatientName(Integer.parseInt(request.getParameter("patientId")));
            out.print(patientName);
        } catch (Exception e) {
            out.print("findNamefailure");
        } finally {
            out.close();
        }
    }
//judgeDoctorTime

    @RequestMapping("/judgeDoctorTime")
    public void judgeDoctorTime(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out=response.getWriter();
        System.out.println("endtimejin");
        try {
            //int doctorId = Integer.parseInt(request.getSession().getAttribute("account").toString());
            int doctorId=1001;
            String date = request.getParameter("date");
            int startTime = Integer.parseInt(request.getParameter("startTime"));
            int endTime = Integer.parseInt(request.getParameter("endTime"));
            if(doctorPageService.judgeDoctorTime(doctorId,date,startTime,endTime)){
                System.out.println("true");
                out.print("success");
            }else {
                out.print("failure");
            }
        } catch (Exception e) {
            out.print("failure");
        } finally {
            out.close();
        }
    }



    @RequestMapping("/appointmentTimeChange")
    public void appointmentTimeChange(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out=response.getWriter();
        try {
            String date = request.getParameter("date");
            int startTime = Integer.parseInt(request.getParameter("startTime"));
            int endTime = Integer.parseInt(request.getParameter("endTime"));
            JSONObject jsonObeject=doctorPageService.appointmentTimeChange(date,startTime,endTime);
            out.print(jsonObeject);

        } catch (Exception e) {
            out.print("failure");
        } finally {
            out.close();
        }
    }

    @RequestMapping("appointmentSubmit")
    public void appointmentSubmit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out=response.getWriter();
        try {
            String info = request.getParameter("info");
            JSONObject jsonObject = JSONObject.fromObject(info);
            if (doctorPageService.appointment(jsonObject)) {
                out.print("success");
            }else {
                out.print("failure");
            }
        } catch (Exception e) {
            out.print("failure");
        } finally {
            out.close();
        }
    }

}
