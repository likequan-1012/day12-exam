package com.lkq.service;

import com.lkq.dao.QueryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueryServiceImpl implements QueryService {
    @Autowired
    private QueryDao queryDao;

    @Override
    public void insertUser(String name) {
        queryDao.insertUser(name);
    }
}
