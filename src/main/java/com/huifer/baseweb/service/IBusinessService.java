package com.huifer.baseweb.service;

import com.huifer.baseweb.base.HuiFerBaseInfo;

/**
 * 业务接口标记
 */
public interface IBusinessService extends HuiFerBaseInfo {

  /**
   * 信息
   *
   * @return "业务接口标记"
   */
  @Override
  default String info() {
    return "业务接口标记";
  }
}
