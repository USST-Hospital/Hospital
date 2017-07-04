package com.usst.service;

/**
 * Created by 28444 on 2017/7/3.
 */
public interface LoginPageService {

    public boolean login(String power, int account, String password);

    String getPersonText(int account, String power);
}
