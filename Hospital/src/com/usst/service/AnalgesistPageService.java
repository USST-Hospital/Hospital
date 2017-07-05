package com.usst.service;

import com.usst.model.Analgesist;
import com.usst.model.Operation;

import java.util.List;

/**
 * Created by 28444 on 2017/7/3.
 */
public interface AnalgesistPageService {

    public Analgesist getAnalgesistById(int account);

    List<Operation> getSchedule(int account);

    List<Operation> getHistory(int account);
}
