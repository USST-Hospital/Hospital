package com.usst.service.impl;

import com.usst.dao.AnalgesistMapper;
import com.usst.dao.OperationMapper;
import com.usst.model.Analgesist;
import com.usst.model.Operation;
import com.usst.service.AnalgesistPageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 28444 on 2017/7/3.
 */
@Service("analgesistPageService")
public class AnalgesistPageServiceImpl implements AnalgesistPageService {
    @Resource
    private AnalgesistMapper analgesistMapper;
    @Resource
    private OperationMapper operationMapper;

    @Override
    public Analgesist getAnalgesistById(int account) {
        return analgesistMapper.selectByPrimaryKey(account);
    }

    @Override
    public List<Operation> getSchedule(int account) {
        System.out.println(account);
        Operation operation=new Operation();
        operation.setAnalgesistId(account);
        return operationMapper.getSchedule(operation);
    }

    @Override
    public List<Operation> getHistory(int account) {
        System.out.println(account);
        Operation operation=new Operation();
        operation.setAnalgesistId(account);
        return operationMapper.getHistory(operation);
    }
}
