package com.usst.service.impl;

import com.usst.dao.DoctorMapper;
import com.usst.model.Doctor;
import com.usst.service.AdminPageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 28444 on 2017/7/3.
 */
@Service("adminPageService")
public class AdminPageServiceImpl implements AdminPageService {

    @Resource
    private DoctorMapper doctorMapper;

    @Override
    public List<Doctor> getAllDoctor() {
        return doctorMapper.getAllDoctor();
    }
}
