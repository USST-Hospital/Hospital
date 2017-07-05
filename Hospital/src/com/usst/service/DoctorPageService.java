package com.usst.service;

import com.usst.model.Doctor;
import com.usst.model.Operation;
import com.usst.model.Patient;
import net.sf.json.JSONObject;

import java.util.List;

/**
 * Created by 28444 on 2017/6/29.
 */
public interface DoctorPageService {

    public Doctor getDoctorInfoById(int id);

    public String appointmentGetPatientName(int patientId);

    public boolean judgeDoctorTime(int doctorId, String date, int startTime, int endTime);


    public JSONObject appointmentTimeChange(String date, int startTime, int endTime);

    public boolean appointment(JSONObject jsonObject);

    public List<Operation> getSchedule(int doctorId);

    public List<Operation> getHistory(int doctorId);

    public Patient getPatientInfo(int account);

    public List<Operation> getPatientSchedule(int account);

    public boolean finish(int operationId);
}
