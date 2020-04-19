package com.huifer.baseweb.service.demo.impl;

import com.huifer.baseweb.mapper.TDemoMapper;
import com.huifer.baseweb.model.db.TDemo;
import com.huifer.baseweb.service.demo.IDemoBusinessService;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Qualifier("demoService")
@Transactional(rollbackFor = Exception.class)
public class IDemoServiceImpl implements IDemoBusinessService {

  @Autowired
  private TDemoMapper tDemoMapper;

  @Override
  public void add() {
    TDemo tDemo = new TDemo();
    tDemo.setName("zs");
    tDemo.setCreateTime(new Date());
    tDemo.setUpdateTime(new Date());
    tDemo.setCreateUser(0);
    tDemo.setUpdateUser(0);

    int i = tDemoMapper.insertSelective(tDemo);
    if (i > 0) {
      log.info("插入成功");
    } else {
      log.error("插入失败");
    }

  }

  @Override
  public void addError() {
    TDemo tDemo = new TDemo();
    tDemo.setName("2222222222");
    tDemo.setCreateTime(new Date());
    tDemo.setUpdateTime(new Date());
    tDemo.setCreateUser(0);
    tDemo.setUpdateUser(0);
    int i = tDemoMapper.insertSelective(tDemo);
    int ic = 1 / 0;
    if (i > 0) {
      log.info("插入成功");
    } else {
      log.error("插入失败");
    }
  }

  @Override
  public void up() {
    TDemo tDemo = tDemoMapper.selectByPrimaryKey(6);
    tDemo.setName("asdasd");
    tDemoMapper.updateByPrimaryKeySelective(tDemo);
  }
}
