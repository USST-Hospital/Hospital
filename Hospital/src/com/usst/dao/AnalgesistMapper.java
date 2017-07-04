package com.usst.dao;

import com.usst.model.Analgesist;
import com.usst.model.Operation;

import java.util.List;

public interface AnalgesistMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Analgesist record);

    int insertSelective(Analgesist record);

    Analgesist selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Analgesist record);

    int updateByPrimaryKey(Analgesist record);

    List<Analgesist> appointmentGetAnalgesist(Operation operation);

    List<Analgesist> changeOperationGetAnalgesist(Operation operation);

    List<Analgesist> getAllAnalgesist();
}