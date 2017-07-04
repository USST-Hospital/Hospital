package com.usst.service.impl;

import com.usst.dao.*;
import com.usst.model.*;
import com.usst.service.DoctorPageService;
import jdk.nashorn.internal.runtime.regexp.joni.constants.OPCode;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 28444 on 2017/6/29.
 */

@Service("doctorPageService")
public class DoctorPageServiceImpl implements DoctorPageService {

    @Resource
    private DoctorMapper doctorMapper;
    @Resource
    private PatientMapper patientMapper;
    @Resource
    private OperationMapper operationMapper;
    @Resource
    private OperationRoomMapper operationRoomMapper;
    @Resource
    private AnalgesistMapper analgesistMapper;
    @Resource
    private NurseMapper nurseMapper;
    @Resource
    private NurseScheduleMapper nurseScheduleMapper;


    @Override
    public Doctor getDoctorInfoById(int id) {
        return doctorMapper.selectByPrimaryKey(id);
    }

    @Override
    public String appointmentGetPatientName(int patientId) {
        Patient patient =patientMapper.selectByPrimaryKey(patientId);
        if (patient == null) {
            return "findNamefailure";
        }

        return patient.getName();
    }

    @Override
    public boolean judgeDoctorTime(int doctorId, String date, int startTime, int endTime) {
        List<Operation> operations = operationMapper.findPartByDoctorId(doctorId);
        for (Operation operation : operations) {
            if (date.equals(operation.getDate()) && startTime < operation.getEndTime() && endTime > operation.getStartTime()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public JSONObject appointmentTimeChange(String date, int startTime, int endTime) {
        Operation operation=new Operation();
        operation.setDate(date);
        operation.setStartTime(startTime);
        operation.setEndTime(endTime);

        List<OperationRoom> operationRooms = operationRoomMapper.appointmentGetOperationRoom(operation);
        List<Analgesist> analgesists = analgesistMapper.appointmentGetAnalgesist(operation);
        List<Nurse> nurses = nurseMapper.appointmentGetNurse(operation);
        List<Doctor> doctors = doctorMapper.appointmentGetDoctor(operation);

        JSONObject resultJSON = new JSONObject();
        JSONArray operationRoomResult = new JSONArray();
        JSONArray analgesistResult = new JSONArray();
        JSONArray nurseResult = new JSONArray();
        JSONArray doctorResult =new JSONArray();

        for (OperationRoom operationRoom : operationRooms) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id",operationRoom.getId());
            jsonObject.put("location", operationRoom.getLocation());
            operationRoomResult.add(jsonObject);
        }

        for (Analgesist analgesist : analgesists) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id",analgesist.getId());
            jsonObject.put("name", analgesist.getName());
            analgesistResult.add(jsonObject);
        }

        for (Nurse nurse : nurses) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id",nurse.getId());
            jsonObject.put("name", nurse.getName());
            nurseResult.add(jsonObject);
        }

        for (Doctor doctor : doctors) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id",doctor.getId());
            jsonObject.put("name", doctor.getName());
            doctorResult.add(jsonObject);
        }


        resultJSON.put("operationRooms", operationRoomResult);
        resultJSON.put("analgesists", analgesistResult);
        resultJSON.put("nurses", nurseResult);
        resultJSON.put("doctors", doctorResult);
        return resultJSON;
    }

    @Override
    public boolean appointment(JSONObject jsonObject) {
        try {
            Operation operation=new Operation();
            operation.setPatientId(jsonObject.getInt("patient"));
            operation.setDate(jsonObject.getString("date"));
            operation.setName(jsonObject.getString("operationName"));
            operation.setOperationRoomId(jsonObject.getInt("operationRoom"));
            operation.setDoctorId(jsonObject.getInt("doctor"));
            operation.setAnalgesistId(jsonObject.getInt("analgesist"));
            operation.setStartTime(jsonObject.getInt("startTime"));
            operation.setEndTime(jsonObject.getInt("endTime"));
            JSONArray nurses=jsonObject.getJSONArray("nurses");


            operationMapper.insertSelective(operation);
            int id = operationMapper.getMaxId();

            for (int i=0;i<nurses.size();i++) {
                NurseSchedule nurseSchedule=new NurseSchedule();
                nurseSchedule.setOperationId(id);
                nurseSchedule.setNurseId(nurses.getInt(i));
                nurseScheduleMapper.insert(nurseSchedule);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<Operation> getSchedule(int doctorId) {
        Operation operation =new Operation();
        operation.setDoctorId(doctorId);
        return operationMapper.getSchedule(operation);
    }

    @Override
    public List<Operation> getHistory(int doctorId) {
        Operation operation=new Operation();
        operation.setDoctorId(doctorId);
        return operationMapper.getHistory(operation);
    }

    @Override
    public Patient getPatientInfo(int account) {
        return patientMapper.selectByPrimaryKey(account);
    }

    @Override
    public List<Operation> getPatientSchedule(int account) {
        Operation operation=new Operation();
        operation.setPatientId(account);
        return operationMapper.getSchedule(operation);
    }

    @Override
    public boolean finish(int operationId) {
        Operation operation=new Operation();
        operation.setId(operationId);
        operation.setStatus(1);
        if (operationMapper.updateByPrimaryKeySelective(operation)>0) {
            return true;
        }else {
            return false;
        }
    }
}
