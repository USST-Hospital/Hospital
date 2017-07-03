package com.usst.dao;

import com.usst.model.Operation;

import java.util.List;

public interface OperationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Operation record);

    int insertSelective(Operation record);

    Operation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Operation record);

    int updateByPrimaryKey(Operation record);


    List<Operation> findPartByDoctorId(int doctorId);

    int getMaxId();

    List<Operation> doctorGetSchedule(int doctorId);

    List<Operation> doctorGetHistory(int doctorId);
}