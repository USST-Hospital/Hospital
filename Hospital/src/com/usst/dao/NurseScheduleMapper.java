package com.usst.dao;

import com.usst.model.NurseSchedule;
import com.usst.model.Operation;

import java.util.List;

public interface NurseScheduleMapper {
    int insert(NurseSchedule record);

    int insertSelective(NurseSchedule record);

    void deleteByOperationId(int operationId);

    List<Operation> getNurseOperationInfo(int account);

    void changeNurseOperationInfo(int account);
}