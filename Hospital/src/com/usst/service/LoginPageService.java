package com.usst.service;

/**
 * Created by 28444 on 2017/7/3.
 */
public interface LoginPageService {

    boolean login(String power, int account, String password);

    String getPersonText(int account, String power);

    boolean getOperationInfo(int account, String power);

    void changeOperationInfo(int account, String power);
}
