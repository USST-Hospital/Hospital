package com.usst.service;

import com.usst.model.Nurse;
import com.usst.model.Operation;

import java.util.List;

/**
 * Created by 28444 on 2017/6/29.
 */
public interface NursePageService {

    Nurse getNurseById(int account);

    List<Operation> getSchedule(int account);

    List<Operation> getHistory(int account);
}
