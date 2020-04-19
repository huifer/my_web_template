package com.huifer.baseweb.service.impl;

import com.huifer.baseweb.constants.InitializrGlobalValue;
import com.huifer.baseweb.service.IInitializrService;
import javax.annotation.PostConstruct;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order
public class IInitializrServiceImpl implements IInitializrService {


  public static final InitializrGlobalValue INITIALIZR_VALUE = new InitializrGlobalValue();


  /**
   * 初始化缓存
   */
  @PostConstruct
  @Override
  public void initCache() {

  }

  /**
   * 获取全局变量
   *
   * @return
   */
  @Override
  public InitializrGlobalValue getValue() {
    return INITIALIZR_VALUE;
  }

  /**
   * 初始化全局变量
   */
  @PostConstruct
  @Override
  public void initGlobalVariable() {
    INITIALIZR_VALUE.getMap().put("1", "abc");
  }
}
