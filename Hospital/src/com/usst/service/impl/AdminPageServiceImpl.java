package com.usst.service.impl;

import com.usst.dao.*;
import com.usst.model.*;
import com.usst.service.AdminPageService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 28444 on 2017/7/3.
 */
@Service("adminPageService")
public class AdminPageServiceImpl implements AdminPageService {

    @Resource
    private DoctorMapper doctorMapper;
    @Resource
    private OperationMapper operationMapper;
    @Resource
    private OperationRoomMapper operationRoomMapper;
    @Resource
    private NurseMapper nurseMapper;
    @Resource
    private AnalgesistMapper analgesistMapper;
    @Resource
    private NurseScheduleMapper nurseScheduleMapper;
    @Resource
    private PatientMapper patientMapper;
    @Resource
    private AccountMapper accountMapper;

    @Override
    public boolean deleteOperation(int operationId) {
        if (operationMapper.deleteByPrimaryKey(operationId)>0) {
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<Operation> getAllOperation() {
        return operationMapper.getAllOperation();
    }

    @Override
    public Operation getOperationById(int id) {
        return operationMapper.selectByPrimaryKey(id);
    }

    @Override
    public JSONObject changeOperationTimeChange(int operationId, String date, int startTime, int endTime) {
        Operation operation=new Operation();
        operation.setDate(date);
        operation.setStartTime(startTime);
        operation.setEndTime(endTime);
        operation.setId(operationId);

        List<OperationRoom> operationRooms = operationRoomMapper.ChangeOperationGetOperationRoom(operation);
        List<Analgesist> analgesists = analgesistMapper.changeOperationGetAnalgesist(operation);
        List<Nurse> nurses = nurseMapper.changeOperationGetNurse(operation);
        List<Doctor> doctors = doctorMapper.changeOperationGetDoctor(operation);

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
    public boolean changeOperationSubmit(JSONObject jsonObject) {
        try {
            Operation operation=new Operation();
            int operationId=jsonObject.getInt("operationId");
            operation.setId(operationId);
            operation.setPatientId(jsonObject.getInt("patient"));
            operation.setDate(jsonObject.getString("date"));
            operation.setName(jsonObject.getString("operationName"));
            operation.setOperationRoomId(jsonObject.getInt("operationRoom"));
            operation.setDoctorId(jsonObject.getInt("doctor"));
            operation.setAnalgesistId(jsonObject.getInt("analgesist"));
            operation.setStartTime(jsonObject.getInt("startTime"));
            operation.setEndTime(jsonObject.getInt("endTime"));
            JSONArray nurses=jsonObject.getJSONArray("nurses");


            operationMapper.updateByPrimaryKeySelective(operation);
            nurseScheduleMapper.deleteByOperationId(operationId);
            for (int i=0;i<nurses.size();i++) {
                NurseSchedule nurseSchedule=new NurseSchedule();
                nurseSchedule.setOperationId(operationId);
                nurseSchedule.setNurseId(nurses.getInt(i));
                nurseScheduleMapper.insert(nurseSchedule);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    /***************************************分割线*******************************************************/
    /***************************************分割线*******************************************************/
    /***************************************分割线*******************************************************/
    /***************************************分割线*******************************************************/


    @Override
    public List<Doctor> getAllDoctor() {
        return doctorMapper.getAllDoctor();
    }

    public List<Patient> getAllPatient() {
        return patientMapper.getAllPatient();
    }

    @Override
    public List<Nurse> getAllnurse(){
        return nurseMapper.getAllNurse();
    }

    public List<Analgesist> getAllAnalgesist(){
        return analgesistMapper.getAllAnalgesist();
    }

    public List<OperationRoom>getAllOperationRoom(){
        return operationRoomMapper.getAllOperationRoom();
    }

//    public List<Operation>getAllOperation(){
//        return operationMapper.getAllOperation();
//    }




    public int addDoctor(Doctor record){
        return doctorMapper.insert(record);
    }
    public int addPatient(Patient record){
        return patientMapper.insert(record);
    }
    public int addAccount(Account acc){
        return accountMapper.insert(acc);
    }
    @Override
    public int addNurse(Nurse acc){
        return nurseMapper.insert(acc);
    }
    public int addAnalgesist(Analgesist acc){
        return analgesistMapper.insert(acc);
    }
//    public int addOperation(Operation acc){
//        return operationMapper.insert(acc);
//    }
    public int addOperationRoom(OperationRoom acc){
        return operationRoomMapper.insert(acc);
    }




    public int delDoctor(int id){
        return accountMapper.deleteByPrimaryKey(id);
    }
    public int delPatient(int id){
        return patientMapper.deleteByPrimaryKey(id);
    }
    public int delAccount(int id){
        return accountMapper.deleteByPrimaryKey(id);
    }
    public int delNurse(int id){
        return nurseMapper.deleteByPrimaryKey(id);
    }
    public int delAnalgesist(int id){
        return analgesistMapper.deleteByPrimaryKey(id);
    }
//    public int delOperation(int id){
//        return operationMapper.deleteByPrimaryKey(id);
//    }
    public int delOperationRoom(int id){
        return operationRoomMapper.deleteByPrimaryKey(id);
    }









    public int updateAccount(Account account){
        return accountMapper.updateByPrimaryKey(account);
    }
    public int updateDoctor(Doctor doc){
        return doctorMapper.updateByPrimaryKey(doc);
    }
    public int updateNurse(Nurse account){
        return nurseMapper.updateByPrimaryKey(account);
    }
    public int updateAnalgesist(Analgesist doc){
        return analgesistMapper.updateByPrimaryKey(doc);
    }
//    public int updateOperation(Operation account){
//        return operationMapper.updateByPrimaryKey(account);
//    }
    public int updateOperationRoom(OperationRoom doc){
        return operationRoomMapper.updateByPrimaryKey(doc);
    }
    public int updatePatient(Patient doc){
        return patientMapper.updateByPrimaryKey(doc);
    }



}
