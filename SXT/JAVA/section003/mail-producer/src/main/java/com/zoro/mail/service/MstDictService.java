package com.zoro.mail.service;

import com.zoro.mail.entity.MstDict;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zhaoguangfu
 * @create 2018/1/23
 * @since 1.0.0
 */
public interface MstDictService {

    List<MstDict> findByStatus(String status);

    List<MstDict> getAll(MstDict dicType);

}