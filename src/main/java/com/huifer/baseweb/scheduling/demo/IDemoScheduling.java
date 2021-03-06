package com.huifer.baseweb.scheduling.demo;

import com.huifer.baseweb.scheduling.InProjectScheduling;

/**
 * 某一个类别的定时任务
 */
public interface IDemoScheduling extends InProjectScheduling {

  /**
   * 定时hello
   */
  void printHello();

  /**
   * 定时任务demo
   *
   * @return 定时任务demo
   */
  @Override
  default String info() {
    return "定时任务demo";
  }
}
