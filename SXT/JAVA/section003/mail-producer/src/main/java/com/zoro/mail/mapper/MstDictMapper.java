package com.zoro.mail.mapper;


import com.zoro.mail.config.database.BaseMapper;
import com.zoro.mail.entity.MstDict;

import java.util.List;

public interface MstDictMapper extends BaseMapper<MstDict> {

    List<MstDict> findByStatus(String status);

}