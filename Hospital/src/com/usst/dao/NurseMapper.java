package com.usst.dao;

import com.usst.model.Nurse;
import com.usst.model.Operation;

import java.util.List;

public interface NurseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Nurse record);

    int insertSelective(Nurse record);

    Nurse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Nurse record);

    int updateByPrimaryKey(Nurse record);

    List<Nurse> appointmentGetNurse(Operation operation);

    List<Nurse> selectByOperationId(int operationId);
}