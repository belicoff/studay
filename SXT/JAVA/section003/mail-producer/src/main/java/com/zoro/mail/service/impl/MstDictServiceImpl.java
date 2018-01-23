package com.zoro.mail.service.impl;

import com.github.pagehelper.PageHelper;
import com.zoro.mail.config.database.ReadOnlyConnection;
import com.zoro.mail.entity.MstDict;
import com.zoro.mail.mapper.MstDictMapper;
import com.zoro.mail.service.MstDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhaoguangfu
 * @create 2018/1/23
 * @since 1.0.0
 */
@Service
public class MstDictServiceImpl implements MstDictService {

    @Autowired
    private MstDictMapper mstDictMapper;

    @ReadOnlyConnection
    @Override
    public List<MstDict> findByStatus(String status) {
        return mstDictMapper.findByStatus(status);
    }

    @ReadOnlyConnection
    public List<MstDict> getAll(MstDict dicType){
        PageHelper.startPage(1, 5);
        return mstDictMapper.selectAll();
    }
}