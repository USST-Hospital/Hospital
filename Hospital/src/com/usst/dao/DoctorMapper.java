package com.usst.dao;

import com.usst.model.Doctor;
import com.usst.model.Operation;

import java.util.List;

public interface DoctorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Doctor record);

    int insertSelective(Doctor record);

    Doctor selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Doctor record);

    int updateByPrimaryKey(Doctor record);

    List<Doctor> getAllDoctor();

    List<Doctor> appointmentGetDoctor(Operation operation);

    List<Doctor> changeOperationGetDoctor(Operation operation);
}