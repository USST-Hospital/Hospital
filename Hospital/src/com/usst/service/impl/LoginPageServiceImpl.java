package com.usst.service.impl;

import com.usst.dao.AccountMapper;
import com.usst.model.Account;
import com.usst.service.LoginPageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by 28444 on 2017/7/3.
 */

@Service("loginPageService")
public class LoginPageServiceImpl implements LoginPageService {

    @Resource
    AccountMapper accountMapper;

    @Override
    public boolean login(String power, int account, String password) {
        Account result = accountMapper.judgeLogin(new Account(account, password, power));
        if (result == null) {
            return false;
        }else {
            return true;
        }

    }
}
