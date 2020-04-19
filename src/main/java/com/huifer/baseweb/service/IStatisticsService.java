package com.huifer.baseweb.service;

import com.huifer.baseweb.base.HuiFerBaseInfo;

/**
 * 统计标记接口
 */
public interface IStatisticsService extends HuiFerBaseInfo {


  /**
   * 信息
   *
   * @return 统计服务
   */
  default String init() {
    return "统计服务";
  }
}
