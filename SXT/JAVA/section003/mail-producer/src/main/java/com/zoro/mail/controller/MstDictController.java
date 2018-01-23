package com.zoro.mail.controller;

import com.github.pagehelper.PageInfo;
import com.zoro.mail.entity.MstDict;
import com.zoro.mail.service.MstDictService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class MstDictController {

    @Resource
    private MstDictService mstDictServiceImpl;

    @RequestMapping(value = "/all")
    public PageInfo<MstDict> getALL(){
        System.out.println("===========>>>>>>>>>>>>getAll");
        MstDict dicType = new MstDict();
        List<MstDict> dicTypeList = mstDictServiceImpl.getAll(dicType);
        return new PageInfo<>(dicTypeList);
    }
}