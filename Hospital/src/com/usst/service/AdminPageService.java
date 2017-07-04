package com.usst.service;

import com.usst.model.*;
import net.sf.json.JSONObject;

import java.util.List;

/**
 * Created by 28444 on 2017/7/3.
 */
public interface AdminPageService {


    boolean deleteOperation(int operationId);

    List<Operation> getAllOperation();

    Operation getOperationById(int id);

    JSONObject changeOperationTimeChange(int operationId, String date, int startTime, int endTime);

    boolean changeOperationSubmit(JSONObject jsonObject);


    /*********************************分割线********************************************/
    /*********************************分割线********************************************/
    /*********************************分割线********************************************/



    List<Doctor> getAllDoctor();

    public int addDoctor(Doctor record);

    public int addAccount(Account acc);

    public int delDoctor(int id);

    public int updateAccount(Account account);

    public int updateDoctor(Doctor doc);

    public int delAccount(int id);

    List<Nurse> getAllnurse();

    int addNurse(Nurse doc);

    int updateNurse(Nurse doc);

    List<Analgesist> getAllAnalgesist();

    int addAnalgesist(Analgesist doc);

    int updateAnalgesist(Analgesist doc);

    List<OperationRoom> getAllOperationRoom();

    int addOperationRoom(com.usst.model.OperationRoom op);

    int delOperationRoom(int parseInt);

    int updateOperationRoom(com.usst.model.OperationRoom operationRoom);

    List<Patient> getAllPatient();

    int addPatient(Patient patient);

    int delPatient(int parseInt);

    int updatePatient(Patient patient);


    int delNurse(int id);

    int delAnalgesist(int id);
}
