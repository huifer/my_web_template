package com.huifer.baseweb.service.login.impl;

import com.huifer.baseweb.service.login.AbsLogin;
import com.huifer.baseweb.service.login.ILoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class QQLoginServiceImpl extends AbsLogin implements ILoginService {

  @Override
  public String info() {
    return "QQ 登录";
  }
}
