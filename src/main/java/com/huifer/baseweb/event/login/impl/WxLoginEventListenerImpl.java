package com.huifer.baseweb.event.login.impl;

import com.huifer.baseweb.event.login.LoginEvent;
import com.huifer.baseweb.event.login.LoginEventListener;
import org.springframework.stereotype.Service;

@Service("wxLoginEventListener")
public class WxLoginEventListenerImpl implements LoginEventListener {

  /**
   * 登陆之后
   *
   * @param loginEvent
   */
  @Override
  public void afterLogin(LoginEvent loginEvent) {
    System.out.println("wx 登陆");
  }
}
