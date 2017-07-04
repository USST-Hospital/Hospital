package com.usst.controller;

import com.usst.model.Doctor;
import com.usst.model.Operation;
import com.usst.model.Patient;
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
        int account = Integer.parseInt(request.getSession().getAttribute("account").toString());
        mav.addObject("doctorInfo",doctorPageService.getDoctorInfoById(account));
        return mav;
    }

    @RequestMapping("/history")
    public ModelAndView history(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("doctor/history");
        int account = Integer.parseInt(request.getSession().getAttribute("account").toString());
        List<Operation> operations = doctorPageService.getHistory(account);
        mav.addObject("operations", operations);
        return mav;
    }

    @RequestMapping("/schedule")
    public ModelAndView schedule(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("doctor/schedule");
        int account = Integer.parseInt(request.getSession().getAttribute("account").toString());
        List<Operation> operations = doctorPageService.getSchedule(account);
        mav.addObject("operations", operations);
        return mav;
    }

    @RequestMapping("/appointment")
    public ModelAndView appointment(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("doctor/appointment");
        int account = Integer.parseInt(request.getSession().getAttribute("account").toString());
        Doctor doctor=doctorPageService.getDoctorInfoById(account);
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
        try {
            int account = Integer.parseInt(request.getSession().getAttribute("account").toString());
            String date = request.getParameter("date");
            int startTime = Integer.parseInt(request.getParameter("startTime"));
            int endTime = Integer.parseInt(request.getParameter("endTime"));
            if(doctorPageService.judgeDoctorTime(account,date,startTime,endTime)){
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

    @RequestMapping("patient_info")
    public ModelAndView patient_info(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("doctor/patient_info");
        try {
            int account = Integer.parseInt(request.getParameter("patientId"));
            Patient patient = doctorPageService.getPatientInfo(account);
            List<Operation> operations = doctorPageService.getPatientSchedule(account);
            mav.addObject("patient", patient);
            mav.addObject("operations", operations);
            if (patient != null) {
                mav.addObject("status", "success");
            }else {
                mav.addObject("status", "failure");
            }
        } catch (Exception e) {
            e.printStackTrace();
            mav.addObject("status", "failure");
        }
        return mav;
    }

    @RequestMapping("search_patient")
    public ModelAndView search_patient(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("doctor/search_patient");
        return mav;
    }


    @RequestMapping("finish")
    public void finish(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out=response.getWriter();
        try {
            int operationId  = Integer.parseInt(request.getParameter("operationId"));
            System.out.println("sdfsdf"+operationId);
            if (doctorPageService.finish(operationId)) {
                out.print("success");
            }else {
                out.print("failure");
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.print("failure");
        } finally {
            out.close();
        }
    }

}
