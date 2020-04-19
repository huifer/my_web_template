package com.huifer.baseweb.scheduling.demo.impl;

import com.huifer.baseweb.scheduling.demo.IDemoScheduling;
import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service("demoScheduling")
public class IDemoSchedulingImpl implements IDemoScheduling {

  public static final String PRINT_HELLO_CRON = "0/10 * * * * ?";

  @Override
  public void printHello() {
    LocalDateTime now = LocalDateTime.now();
    System.out.println(now + "hello");
  }

  @Override
  public String info() {
    return "这是一个定时任务demo";
  }
}
