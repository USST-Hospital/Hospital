package com.usst.dao;

import com.sun.corba.se.spi.orb.OperationFactory;
import com.usst.model.Operation;
import com.usst.model.OperationRoom;

import java.util.List;

public interface OperationRoomMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OperationRoom record);

    int insertSelective(OperationRoom record);

    OperationRoom selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OperationRoom record);

    int updateByPrimaryKey(OperationRoom record);

    List<OperationRoom> appointmentGetOperationRoom(Operation operation);

    List<OperationRoom> ChangeOperationGetOperationRoom(Operation operation);

    List<OperationRoom> getAllOperationRoom();
}