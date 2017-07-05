package com.usst.service.impl;

import com.usst.dao.*;
import com.usst.model.Account;
import com.usst.model.Operation;
import com.usst.service.LoginPageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 28444 on 2017/7/3.
 */

@Service("loginPageService")
public class LoginPageServiceImpl implements LoginPageService {

    @Resource
    private AccountMapper accountMapper;
    @Resource
    private DoctorMapper doctorMapper;
    @Resource
    private AnalgesistMapper analgesistMapper;
    @Resource
    private NurseMapper nurseMapper;
    @Resource
    private OperationMapper operationMapper;
    @Resource
    private NurseScheduleMapper nurseScheduleMapper;

    @Override
    public boolean login(String power, int account, String password) {
        Account result = accountMapper.judgeLogin(new Account(account, password, power));
        if (result == null) {
            return false;
        }else {
            return true;
        }

    }

    @Override
    public String getPersonText(int account, String power) {
        String personText = null;
        if ("admin".equals(power)) {
            personText = "管理员";
        }else if ("doctor".equals(power)) {
            personText = account + "  " + doctorMapper.selectByPrimaryKey(account).getName()+"医生";
        }else if ("analgesist".equals(power)) {
            personText = account + "  " + analgesistMapper.selectByPrimaryKey(account).getName()+"麻醉师";
        }else if ("nurse".equals(power)) {
            personText = account + "  " + nurseMapper.selectByPrimaryKey(account).getName()+"护士";
        }
        return personText;
    }

    @Override
    public boolean getOperationInfo(int account, String power) {
        if ("analgesist".equals(power)) {
            List<Operation> operations = operationMapper.getAnalgesistOperationInfo(account);
            if (operations.size() > 0) {
                return true;
            }else {
                return false;
            }
        }else if ("nurse".equals(power)) {
            List<Operation> operations = nurseScheduleMapper.getNurseOperationInfo(account);
            if (operations.size() > 0) {
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    @Override
    public void changeOperationInfo(int account, String power) {
        if ("analgesist".equals(power)) {
            operationMapper.changeAnalgesistOperationInfo(account);

        }else if ("nurse".equals(power)) {
            nurseScheduleMapper.changeNurseOperationInfo(account);
        }
    }
}
