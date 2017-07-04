package com.usst.dao;

import com.usst.model.NurseSchedule;

public interface NurseScheduleMapper {
    int insert(NurseSchedule record);

    int insertSelective(NurseSchedule record);

    void deleteByOperationId(int operationId);
}