package com.usst.service.impl;

import com.usst.dao.NurseMapper;
import com.usst.dao.OperationMapper;
import com.usst.model.Nurse;
import com.usst.model.Operation;
import com.usst.service.NursePageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 28444 on 2017/6/29.
 */

@Service("NursePageService")
public class NursePageServiceImpl implements NursePageService {

    @Resource
    private NurseMapper nurseMapper;
    @Resource
    private OperationMapper operationMapper;

    @Override
    public Nurse getNurseById(int account) {
        return nurseMapper.selectByPrimaryKey(account);
    }

    @Override
    public List<Operation> getSchedule(int account) {
        System.out.println(account);
        Operation operation=new Operation();
        operation.setNurseId(account);
        return operationMapper.getSchedule(operation);
    }

    @Override
    public List<Operation> getHistory(int account) {
        System.out.println(account);
        Operation operation=new Operation();
        operation.setNurseId(account);
        return operationMapper.getHistory(operation);
    }

}
