package com.usst.dao;

import com.usst.model.Account;

public interface AccountMapper {
    int deleteByPrimaryKey(Integer account);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Integer account);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
}