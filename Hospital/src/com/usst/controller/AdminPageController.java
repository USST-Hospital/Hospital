package com.usst.controller;

import com.usst.model.*;
import com.usst.service.AdminPageService;
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
@RequestMapping("/admin")
public class AdminPageController {

    @Resource
    private AdminPageService adminPageService;
    @Resource
    private DoctorPageService doctorPageService;

    @RequestMapping("/admin")
    public String admin() {
        return "admin/admin";
    }

    @RequestMapping("/operation/add_operation")
    public String addOperation() {
        return "admin/operation/add_operation";
    }

    @RequestMapping("/operation/all_operation")
    public ModelAndView allOperation(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("admin/operation/all_operation");
        List<Operation> operations = adminPageService.getAllOperation();
        mav.addObject("operations", operations);
        return mav;
    }

    @RequestMapping("/operation/update_operation")
    public ModelAndView updateOperation(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        int id = Integer.parseInt(request.getParameter("operationId"));
        mav.setViewName("admin/operation/update_operation");
        Operation operation = adminPageService.getOperationById(id);
        mav.addObject("operation", operation);
        return mav;
    }


    @RequestMapping("/operation/deleteOperation")
    public void finish(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out=response.getWriter();
        try {
            int operationId  = Integer.parseInt(request.getParameter("operationId"));
            if (adminPageService.deleteOperation(operationId)) {
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


    @RequestMapping("/operation/appointmentGetPatientName")
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


    @RequestMapping("/operation/appointmentTimeChange")
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

    @RequestMapping("/operation/appointmentSubmit")
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

    @RequestMapping("/operation/changeOperationTimeChange")
    public void changeOperationTimeChange(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out=response.getWriter();
        try {
            int operationId = Integer.parseInt(request.getParameter("operationId"));
            String date = request.getParameter("date");
            int startTime = Integer.parseInt(request.getParameter("startTime"));
            int endTime = Integer.parseInt(request.getParameter("endTime"));
            JSONObject jsonObeject=adminPageService.changeOperationTimeChange(operationId,date,startTime,endTime);
            out.print(jsonObeject);

        } catch (Exception e) {
            out.print("failure");
        } finally {
            out.close();
        }
    }



    @RequestMapping("/operation/changeOperationSubmit")
    public void changeOperationSubmit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out=response.getWriter();
        try {
            String info = request.getParameter("info");
            JSONObject jsonObject = JSONObject.fromObject(info);
            if (adminPageService.changeOperationSubmit(jsonObject)) {
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




    /**********************************   分割线********************************************************/
    /**********************************   分割线********************************************************/
    /**********************************   分割线********************************************************/
    /**********************************   分割线********************************************************/






    @RequestMapping("/doctor/all_doctor.do")
    public ModelAndView doctor(){
        ModelAndView mav = new ModelAndView();
        List<Doctor> doctors = adminPageService.getAllDoctor();
        mav.addObject("doctors", doctors);
        mav.setViewName("admin/doctor/all_doctor");
        return mav;
    }
    @RequestMapping("/patient/all_patient.do")
    public ModelAndView patient(){
        ModelAndView mav = new ModelAndView();
        List<Patient> patients = adminPageService.getAllPatient();
        mav.addObject("patients", patients);
        mav.setViewName("admin/patient/all_patient");
        return mav;
    }

    @RequestMapping("/doctor/add_doctor")
    public ModelAndView addDoctor() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("admin/doctor/add_doctor");
        return mav;
    }
    @RequestMapping("nurse/all_nurse.do")
    public ModelAndView nurse(){
        ModelAndView mav = new ModelAndView();
        List<Nurse> nurse = adminPageService.getAllnurse();
        mav.addObject("nurses", nurse);
        mav.setViewName("admin/nurse/all_nurse");
        return mav;
    }
    @RequestMapping("analgesist/all_analgesist.do")
    public ModelAndView analgesist(){
        ModelAndView mav = new ModelAndView();
        List<Analgesist> analgesist = adminPageService.getAllAnalgesist();
        mav.addObject("analgesists", analgesist);
        mav.setViewName("admin/analgesist/all_analgesist");
        return mav;
    }
    @RequestMapping("operation_room/all_operation_room.do")
    public ModelAndView OperationRoom(){
        ModelAndView mav = new ModelAndView();
        List<OperationRoom> operationRooms = adminPageService.getAllOperationRoom();
        mav.addObject("operationRooms", operationRooms);
        mav.setViewName("admin/operation_room/all_operation_room");
        return mav;
    }

    @RequestMapping("/nurse/add_nurse")
    public ModelAndView addnurse() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("admin/nurse/add_nurse");
        return mav;
    }
    @RequestMapping("/patient/add_patient")
    public ModelAndView addpatient() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("admin/patient/add_patient");
        return mav;
    }
    @RequestMapping("/operation_room/add_operation_room")
    public ModelAndView addoperationroom() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("admin/operation_room/add_operation_room");
        return mav;
    }

    @RequestMapping("/analgesist/add_analgesist")
    public ModelAndView addanalgesist() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("admin/analgesist/add_analgesist");
        return mav;
    }

    @RequestMapping("/operation_room/adminAddOperationRoom.do")
    public void adminAddOperationroom(HttpServletResponse response,HttpServletRequest request){
        String id=request.getParameter("id");
        String location=request.getParameter("location");
        OperationRoom op=new OperationRoom(Integer.parseInt(id), location);
        adminPageService.addOperationRoom(op);
    }
    @RequestMapping("/patient/adminAddPatient.do")
    public void adminAddPatient(HttpServletResponse response,HttpServletRequest request){
        String id=request.getParameter("id");
        String name=request.getParameter("name");
        String sex=request.getParameter("sex");
        String age=request.getParameter("age");
        String number=request.getParameter("number");
        Patient patient=new Patient(Integer.parseInt(id), name, sex, Integer.parseInt(age), number);
        adminPageService.addPatient(patient);
    }

    @RequestMapping("/doctor/adminAddDoctor.do")
    public void adminAddDoctor(HttpServletResponse response,HttpServletRequest request){
            //ModelAndView mav=new ModelAndView();
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String sex = request.getParameter("sex");
            String age = request.getParameter("age");
            String number = request.getParameter("number");
            String password = request.getParameter("password");
    	    System.out.println(id+" "+name+" "+sex+" "+age+" "+number+" "+password+" ");
            Account acc = new Account(Integer.parseInt(id), password, "doctor");
            //System.out.println(acc);
            adminPageService.addAccount(acc);
            Doctor doc = new Doctor(password, Integer.parseInt(id), name, sex, Integer.parseInt(age), number);
            adminPageService.addDoctor(doc);
    }
    @RequestMapping("/analgesist/adminAddAnalgesist.do")
    public void adminAddAnalgesist(HttpServletResponse response,HttpServletRequest request){
        //ModelAndView mav=new ModelAndView();
        String id=request.getParameter("id");
        String name=request.getParameter("name");
        String sex=request.getParameter("sex");
        String age=request.getParameter("age");
        String number=request.getParameter("number");
        String password=request.getParameter("password");
//    	System.out.println(id+" "+name+" "+sex+" "+age+" "+number+" "+password+" ");
        Account acc=new Account(Integer.parseInt(id),password,"analgesist");
        //System.out.println(acc);
        adminPageService.addAccount(acc);
        Analgesist doc=new Analgesist(Integer.parseInt(id), name, sex, Integer.parseInt(age), number,password);
        adminPageService.addAnalgesist(doc);
    }

    @RequestMapping("/nurse/adminAddNurse.do")
    public void adminAddNurse(HttpServletResponse response,HttpServletRequest request){
        //ModelAndView mav=new ModelAndView();
        String id=request.getParameter("id");
        String name=request.getParameter("name");
        String sex=request.getParameter("sex");
        String age=request.getParameter("age");
        String number=request.getParameter("number");
        String password=request.getParameter("password");
//    	System.out.println(id+" "+name+" "+sex+" "+age+" "+number+" "+password+" ");
        Account acc=new Account(Integer.parseInt(id),password,"nurse");
        //System.out.println(acc);
        adminPageService.addAccount(acc);
        Nurse doc=new Nurse(Integer.parseInt(id), name, sex, Integer.parseInt(age), number,password);
        adminPageService.addNurse(doc);
    }
    @RequestMapping("/doctor/adminDelDoctor.do")
    public void adminDelDoctor(HttpServletResponse response,HttpServletRequest request){
        String id=request.getParameter("id");
        //adminPageService.delDoctor(Integer.parseInt(id));
        adminPageService.delDoctor(Integer.parseInt(id));
    }
    @RequestMapping("/patient/adminDelPatient.do")
    public void adminDelPatient(HttpServletResponse response,HttpServletRequest request){
        String id=request.getParameter("id");
        //adminPageService.delDoctor(Integer.parseInt(id));
        adminPageService.delPatient(Integer.parseInt(id));
    }

    @RequestMapping("/operation_room/adminDelOperationroom.do")
    public void adminDelOperationroom(HttpServletResponse response,HttpServletRequest request){
        String id=request.getParameter("id");
        //adminPageService.delDoctor(Integer.parseInt(id));
        adminPageService.delOperationRoom(Integer.parseInt(id));
    }
    @RequestMapping("/nurse/adminDelNurse.do")
    public void adminDelNurse(HttpServletResponse response,HttpServletRequest request){
        String id=request.getParameter("id");
        //adminPageService.delDoctor(Integer.parseInt(id));
        adminPageService.delNurse(Integer.parseInt(id));

    }
    @RequestMapping("/analgesist/adminDelAnalgesist.do")
    public void adminDelAnalgesist(HttpServletResponse response,HttpServletRequest request){
        String id=request.getParameter("id");
        //adminPageService.delDoctor(Integer.parseInt(id));
        adminPageService.delAnalgesist(Integer.parseInt(id));

    }

    @RequestMapping("/doctor/adminUpdataDoctor.do")
    public void adminUpdataDoctor(HttpServletResponse response,HttpServletRequest request){
        String id=request.getParameter("id");
        String name=request.getParameter("name");
        String sex=request.getParameter("sex");
        String age=request.getParameter("age");
        String number=request.getParameter("number");
        String password=request.getParameter("password");
        Account acc=new Account(Integer.parseInt(id),password,"doctor");
        Doctor doc=new Doctor(password,Integer.parseInt(id), name, sex, Integer.parseInt(age), number);
        adminPageService.updateAccount(acc);
        adminPageService.updateDoctor(doc);
    }
    @RequestMapping("/patient/adminUpdataPatient.do")
    public void adminUpdataPatient(HttpServletResponse response,HttpServletRequest request){
        String id=request.getParameter("id");
        String name=request.getParameter("name");
        String sex=request.getParameter("sex");
        String age=request.getParameter("age");
        String number=request.getParameter("number");
        Patient patient=new Patient(Integer.parseInt(id), name, sex, Integer.parseInt(age), number);
        adminPageService.updatePatient(patient);
    }
    @RequestMapping("/operation_room/adminUpdataOperationroom.do")
    public void adminUpdataOperationroom(HttpServletResponse response,HttpServletRequest request){
        String id=request.getParameter("id");
        String location=request.getParameter("location");
        OperationRoom operationRoom=new OperationRoom(Integer.parseInt(id), location);
        adminPageService.updateOperationRoom(operationRoom);

    }
    @RequestMapping("/analgesist/adminUpdataAnalgesist.do")
    public void adminUpdataAnalgesist(HttpServletResponse response,HttpServletRequest request){
        String id=request.getParameter("id");
        String name=request.getParameter("name");
        String sex=request.getParameter("sex");
        String age=request.getParameter("age");
        String number=request.getParameter("number");
        String password=request.getParameter("password");
        Account acc=new Account(Integer.parseInt(id),password,"nurse");
        Analgesist doc=new Analgesist(Integer.parseInt(id), name, sex, Integer.parseInt(age), number,password);
        adminPageService.updateAccount(acc);
        adminPageService.updateAnalgesist(doc);

    }
    @RequestMapping("/nurse/adminUpdataNurse.do")
    public void adminUpdataNurse(HttpServletResponse response,HttpServletRequest request){
        String id=request.getParameter("id");
        String name=request.getParameter("name");
        String sex=request.getParameter("sex");
        String age=request.getParameter("age");
        String number=request.getParameter("number");
        String password=request.getParameter("password");
        Account acc=new Account(Integer.parseInt(id),password,"nurse");
        Nurse doc=new Nurse(Integer.parseInt(id), name, sex, Integer.parseInt(age), number,password);
        adminPageService.updateAccount(acc);
        adminPageService.updateNurse(doc);

    }



}
